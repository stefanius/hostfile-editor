package frontend;

import controllers.HostlistController;
import main.Listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

/**
 * Created by stefanius on 09/06/14.
 */
public class View extends JFrame {

    protected Container contentPane;

    ListPane listPane;


    public View(HostlistController controller, ListPane listPane)
    {
        super();
        this.contentPane = this.getContentPane();
        this.contentPane.setLayout(new FlowLayout());
        this.pack();
        this.setSize(500, 300);
        this.setVisible(true);

        JButton btn = new JButton();

        btn.addActionListener(new Listener(listPane, controller));

        btn.setText("Save");

        this.listPane = listPane;
        this.contentPane.add(this.listPane);


        this.contentPane.add(btn);

        this.pack();
    }

    public void setListpane(ListPane listPane)
    {
        this.listPane = listPane;
        this.contentPane.add(this.listPane);
        this.pack();
    }
}
