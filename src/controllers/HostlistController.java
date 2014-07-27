package controllers;

import extractors.HostnameFromHostfileExtractor;
import extractors.IPv4Extractor;
import extractors.IPv6Extractor;
import frontend.ListPane;
import frontend.PaneItem;
import interfaces.IExtractor;
import interfaces.IValidator;
import listeners.ChangeHostnameFieldListener;
import listeners.ChangeIpFieldListener;
import main.HostData;
import misc.HostfileProccessorCreator;
import misc.HostfileProcessor;
import misc.IpVersionChecker;
import observer.ConsoleObserver;
import observer.GraphicalObserver;
import subject.Record;
import switchChecker.HashtagCommentSwitch;
import validators.ContainsIPv4Validator;
import validators.ContainsIPv6Validator;

import javax.swing.*;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by stefanius on 10/06/14.
 */
public class HostlistController {

    protected ArrayList<Record> records;

    protected String hostfile;

    protected IpVersionChecker ipVersionChecker;

    protected IPv4Extractor iPv4Extractor;

    protected IPv6Extractor iPv6Extractor;

    protected HostnameFromHostfileExtractor hostnameExtractor;

    protected HostfileProccessorCreator hostfileProccessorCreator;

    protected HostfileProcessor hostfileProcessor;

    protected HashtagCommentSwitch hashtagCommentSwitch;

    protected ListPane listPane;

    public HostlistController(String hostfile) {
        this.records = new ArrayList<Record>();
        this.ipVersionChecker = new IpVersionChecker(new ContainsIPv4Validator(), new ContainsIPv6Validator());
        this.hostnameExtractor = new HostnameFromHostfileExtractor();
        this.hostfileProccessorCreator = new HostfileProccessorCreator(hostfile);
        this.hostfileProcessor = this.hostfileProccessorCreator.getHostfileProcessor();
        this.hashtagCommentSwitch = new HashtagCommentSwitch();
        this.iPv4Extractor = new IPv4Extractor();
        this.iPv6Extractor = new IPv6Extractor();

        this.hostfile = hostfile;
    }

    public void readHostfile() {
        this.hostfileProcessor.read();

        for(String line : this.hostfileProcessor.getLines()){
            if (this.ipVersionChecker.isOrHasIpv4(line)) {
                this.createAndAddNewRecord(line, this.iPv4Extractor, this.hostnameExtractor);
            } else if (this.ipVersionChecker.isOrHasIpv6(line)) {
                this.createAndAddNewRecord(line, this.iPv6Extractor, this.hostnameExtractor);
            }
        }
    }

    protected void createAndAddNewRecord(String line, IExtractor ipExtractor, IExtractor hostnameExtractor){
        Record record = new Record(
                this.hashtagCommentSwitch.check(line),
                ipExtractor.extract(line),
                hostnameExtractor.extract(line)
        );

        JCheckBox enabled = new JCheckBox();
        JTextField ip = new JTextField();
        JTextField hostname = new JTextField();

        ChangeHostnameFieldListener hostnameListener = new ChangeHostnameFieldListener(record, hostname);
        ChangeIpFieldListener ipListener = new ChangeIpFieldListener(record, ip);

        hostname.addKeyListener(hostnameListener);
        ip.addKeyListener(ipListener);

        record.registerObserver(new ConsoleObserver());
        record.registerObserver(new GraphicalObserver(this.listPane, enabled, ip, hostname));

        this.records.add(record);
    }


    public void addRecord(Record record){
        this.records.add(record);
    }

    public ArrayList<Record> getRecords() {
        return this.records;
    }

    public void notifyObservers(){
        for(Record record : this.records){
            record.notifyObservers();
        }

    }

    public void save(ArrayList<PaneItem> list) {
        StringBuffer buffer = new StringBuffer();
        for (PaneItem item : list) {

            if (!item.getEnabled().isSelected()) {
                buffer.append("#");
            }

            if (item.getIp().getText().length() > 1 && item.getHsotname().getText().length() > 1) {
                buffer.append(String.format("%-40s %s", item.getIp().getText(), item.getHsotname().getText()));

                buffer.append("\n");
            }
        }

        try {
            PrintWriter writer = new PrintWriter(this.hostfile, "UTF-8");
            writer.println(buffer);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setListPane(ListPane listPane) {
        this.listPane = listPane;
    }
}
