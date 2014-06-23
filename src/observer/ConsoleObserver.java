package observer;

import observer.pattern.base.Observer;
import observer.pattern.interfaces.ISubject;
import subject.Record;
import java.awt.*;

/**
 * Created by stefanius on 19/06/14.
 */
public class ConsoleObserver extends Observer {

    @Override
    public void update(ISubject subject) {
        Record record = (Record) subject;

        System.out.println(record.getIp() + " " + record.getHostname());
    }
}
