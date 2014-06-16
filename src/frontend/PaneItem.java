package frontend;

import javax.swing.*;

/**
 * Created by stefanius on 14/06/14.
 */
public class PaneItem {

    protected JCheckBox enabled;

    protected JTextField ip;

    protected JTextField hsotname;

    public PaneItem(JCheckBox enabled, JTextField ip, JTextField hsotname) {
        this.enabled = enabled;
        this.ip = ip;
        this.hsotname = hsotname;
    }

    public JCheckBox getEnabled() {
        return enabled;
    }

    public JTextField getIp() {
        return ip;
    }

    public JTextField getHsotname() {
        return hsotname;
    }
}
