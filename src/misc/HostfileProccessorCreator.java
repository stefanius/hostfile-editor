package misc;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by stefanius on 18/06/14.
 */
public class HostfileProccessorCreator {

    protected String filename;

    protected HostfileProcessor hostfileProcessor;

    public HostfileProccessorCreator(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }

    public HostfileProcessor getHostfileProcessor() {

        if (this.hostfileProcessor == null) {
            this.hostfileProcessor = this.create();
        }

        return this.hostfileProcessor;
    }

    protected HostfileProcessor create() {

        try {
            FileReader fr = new FileReader(this.filename);

            return new HostfileProcessor(this.filename, new BufferedReader(fr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
