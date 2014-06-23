package main;

import controllers.HostlistController;
import frontend.ListPane;
import frontend.View;

import misc.HostfileProccessorCreator;
import observer.pattern.interfaces.ISubject;
/**
 * Created by stefanius on 09/06/14.
 */
public class Main {
    public static void main(String [ ] args)
    {
        ListPane listPane = new ListPane();

        HostlistController controller = new HostlistController("/etc/hosts");
        View view = new View(controller, listPane);

        controller.setListPane(listPane);
        controller.readHostfile();
        controller.notifyObservers();
        view.pack();
    }
}
