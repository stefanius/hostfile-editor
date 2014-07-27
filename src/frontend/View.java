package frontend;

import controllers.HostlistController;
import listeners.AddButtonListener;
import listeners.SaveListener;

import javax.swing.*;
import java.awt.*;

/**
 * Created by stefanius on 09/06/14.
 */
public class View extends JFrame {

    protected Container contentPane;

    protected JButton saveButton;

    protected JButton addButton;

    protected ListPane listPane;

    protected JPanel buttonPane;

    public View(HostlistController controller, ListPane listPane)
    {
        super();
        this.contentPane = this.getContentPane();
        this.contentPane.setLayout(new FlowLayout());
        this.buttonPane = new JPanel();
        this.buttonPane.setLayout(new GridLayout(3,0));
        this.pack();
        this.setSize(500, 300);
        this.setVisible(true);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        saveButton = new JButton();
        addButton = new JButton();

        saveButton.addActionListener(new SaveListener(this, listPane, controller));
        addButton.addActionListener(new AddButtonListener(this, listPane, controller));

        saveButton.setText("Save");
        addButton.setText("add");

        this.listPane = listPane;
        this.contentPane.add(this.listPane);

        this.buttonPane.add(saveButton);
        this.buttonPane.add(addButton);

        this.contentPane.add(this.buttonPane);
        this.pack();
    }

    public void setListpane(ListPane listPane)
    {
        this.listPane = listPane;
        this.contentPane.add(this.listPane);
        this.pack();
    }
}
