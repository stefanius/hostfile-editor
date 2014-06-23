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
}
