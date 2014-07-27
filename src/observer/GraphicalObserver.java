package observer;

import observer.pattern.base.Observer;
import observer.pattern.interfaces.ISubject;
import subject.Record;

import javax.swing.*;
import java.awt.*;

/**
 * Created by stefanius on 19/06/14.
 */
public class GraphicalObserver extends Observer {

    protected JPanel viewElement;

    protected JCheckBox checkbox;

    protected JTextField ip;

    protected JTextField hostname;

    public GraphicalObserver(JPanel viewElement, JCheckBox checkbox, JTextField ip, JTextField hostname) {
        super();
        this.viewElement = viewElement;
        this.checkbox = checkbox;
        this.ip = ip;
        this.hostname = hostname;

        this.viewElement.add(this.checkbox);
        this.viewElement.add(this.ip);
        this.viewElement.add(this.hostname);
    }

    @Override
    public void update(ISubject subject) {
        Record record = (Record) subject;

        this.checkbox.setSelected(record.isEnabled());
        this.ip.setText(record.getIp());
        this.hostname.setText(record.getHostname());
    }

    public Component getViewElement() {
        return viewElement;
    }

    public void setViewElement(JPanel viewElement) {
        this.viewElement = viewElement;
    }
}
