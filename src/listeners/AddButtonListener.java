package listeners;

import controllers.HostlistController;
import frontend.ListPane;
import frontend.View;
import observer.ConsoleObserver;
import observer.GraphicalObserver;
import subject.Record;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stefanius on 14/06/14.
 */
public class AddButtonListener implements ActionListener{

    protected ListPane listPane;

    protected HostlistController controller;

    protected View view;

    public AddButtonListener(View view, ListPane listPane, HostlistController controller) {
        this.listPane = listPane;
        this.controller = controller;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Record record = new Record(true, "IP", "Hostname");

        JCheckBox enabled = new JCheckBox();
        JTextField ip = new JTextField();
        JTextField hostname = new JTextField();

        ChangeHostnameFieldListener hostnameListener = new ChangeHostnameFieldListener(record, hostname);

        hostname.addKeyListener(hostnameListener);

        record.registerObserver(new ConsoleObserver());
        record.registerObserver(new GraphicalObserver(this.listPane, enabled, ip, hostname));

        record.notifyObservers();
        this.controller.addRecord(record);
        this.view.pack();
    }
}

