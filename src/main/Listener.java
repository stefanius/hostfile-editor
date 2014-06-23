package main;

import controllers.HostlistController;
import frontend.ListPane;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by stefanius on 14/06/14.
 */
public class Listener implements ActionListener{

    protected ListPane listPane;

    protected HostlistController controller;

    public Listener(ListPane listPane, HostlistController controller) {
        this.listPane = listPane;
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
       // this.controller.save(listPane.getPaneItems());
    }
}

