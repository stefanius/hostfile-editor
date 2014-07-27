package listeners;

import controllers.HostlistController;
import frontend.ListPane;
import frontend.View;
import subject.Record;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by stefanius on 14/06/14.
 */
public class SaveListener implements ActionListener{

    protected ListPane listPane;

    protected HostlistController controller;

    protected View view;

    public SaveListener(View view, ListPane listPane, HostlistController controller) {
        this.listPane = listPane;
        this.controller = controller;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ArrayList<Record> records = this.controller.getRecords();

        for(Record record : records){
            System.out.println(record.getHostname());
        }

       // this.controller.save(listPane.getPaneItems());
    }
}

