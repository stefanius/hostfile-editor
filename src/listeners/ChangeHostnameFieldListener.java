package listeners;

import controllers.HostlistController;
import frontend.ListPane;
import frontend.View;
import observer.ConsoleObserver;
import observer.GraphicalObserver;
import observer.pattern.base.Observer;
import subject.Record;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by stefanius on 14/06/14.
 */
public class ChangeHostnameFieldListener implements KeyListener{

    protected Record record;

    protected JTextField hostname;

    public ChangeHostnameFieldListener(Record record, JTextField hostname) {
        this.record = record;
        this.hostname = hostname;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        this.record.setHostname(this.hostname.getText());
    }
}
