package controllers;

import extractors.HostnameFromHostfileExtractor;
import extractors.IPv4Extractor;
import extractors.IPv6Extractor;
import frontend.PaneItem;
import interfaces.IExtractor;
import interfaces.IValidator;
import main.HostData;
import reader.StringReader;
import switchChecker.HashtagCommentSwitch;
import validators.ContainsIPv4Validator;
import validators.ContainsIPv6Validator;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by stefanius on 10/06/14.
 */
public class HostlistController {

    protected HostData hostData;

    protected String hostfile;

    protected IValidator ipv4Validator;

    protected IValidator ipv6Validator;

    protected IPv4Extractor ipExtractor;

    protected IPv6Extractor ip6Extractor;

    protected HostnameFromHostfileExtractor hostnameExtractor;

    protected StringReader reader;

    public HostlistController(String hostfile) {
        this.hostData = new HostData();
        this.ipv4Validator = new ContainsIPv4Validator();
        this.ipv6Validator = new ContainsIPv6Validator();
        this.ipExtractor = new IPv4Extractor();
        this.ip6Extractor = new IPv6Extractor();
        this.hostnameExtractor = new HostnameFromHostfileExtractor();
        this.reader = new StringReader(hostfile);
        this.hostfile = hostfile;
    }

    public void readHostfile()
    {
        this.reader.read();

        for(String line : this.reader.getLines()){
            if (line != null && !line.isEmpty() && this.ipv4Validator.validate(line)){
                 this.hostData.addRow(new HashtagCommentSwitch().check(line), this.ipExtractor.extract(line), this.hostnameExtractor.extract(line));
            }

            if (line != null && !line.isEmpty() && this.ipv6Validator.validate(line)){
                this.hostData.addRow(new HashtagCommentSwitch().check(line), this.ip6Extractor.extract(line), this.hostnameExtractor.extract(line));
            }
        }
    }

    public HostData getHostData()
    {
        return this.hostData;
    }

    public void save(ArrayList<PaneItem> list)
    {
        StringBuffer buffer = new StringBuffer();
        for(PaneItem item : list){

            if(!item.getEnabled().isSelected()){
                buffer.append("#");
            }

            if(item.getIp().getText().length() > 1 && item.getHsotname().getText().length() > 1) {
                buffer.append(String.format("%-40s %s", item.getIp().getText(), item.getHsotname().getText()));

                buffer.append("\n");
            }
        }

        try{
            PrintWriter writer = new PrintWriter(this.hostfile, "UTF-8");
            writer.println(buffer);
            writer.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
