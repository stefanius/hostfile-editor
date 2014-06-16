package frontend;

import main.Row;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by stefanius on 10/06/14.
 */
public class ListPane extends JPanel {

    protected ArrayList<PaneItem> paneItems;

    public ListPane()
    {
        super();
        this.setLayout(new GridLayout(0, 3));
        this.paneItems = new ArrayList<PaneItem>();
    }

    public void addListItem(Row row)
    {
        JCheckBox checkbox = new JCheckBox();
        JTextField ip = new JTextField();
        JTextField hostname = new JTextField();

        checkbox.setSelected(row.isEnabled());
        ip.setText(row.getIp());
        hostname.setText(row.getHost());

        this.paneItems.add(new PaneItem(checkbox, ip, hostname));

        this.add(checkbox);
        this.add(ip);
        this.add(hostname);
    }

    public ArrayList<PaneItem> getPaneItems() {
        return paneItems;
    }
}
