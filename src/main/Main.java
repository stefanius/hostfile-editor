package main;

import controllers.HostlistController;
import frontend.ListPane;
import frontend.View;

/**
 * Created by stefanius on 09/06/14.
 */
public class Main {
    public static void main(String [ ] args)
    {
        ListPane listPane = new ListPane();

        HostlistController controller = new HostlistController("/etc/hosts");
        View view = new View(controller, listPane);

        controller.readHostfile();

        for(Row row : controller.getHostData().getRows()){
            listPane.addListItem(row);
        }

        listPane.setVisible(true);
        view.setListpane(listPane);
    }
}
