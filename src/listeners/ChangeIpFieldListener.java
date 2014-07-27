package listeners;

import subject.Record;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by stefanius on 14/06/14.
 */
public class ChangeIpFieldListener implements KeyListener{

    protected Record record;

    protected JTextField ip;

    public ChangeIpFieldListener(Record record, JTextField ip) {
        this.record = record;
        this.ip = ip;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        this.record.setIp(this.ip.getText());
    }
}
