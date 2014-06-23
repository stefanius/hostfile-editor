package misc;

import validators.ContainsIPv4Validator;
import validators.ContainsIPv6Validator;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * Created by stefanius on 09/06/14.
 */
public class HostfileProcessor {

    protected ArrayList<String> lines;

    protected String filename;

    protected BufferedReader bufferedReader;

    protected IpVersionChecker ipVersionChecker;

    public HostfileProcessor(String filename, BufferedReader bufferedReader) {
        this();
        this.filename = filename;
        this.bufferedReader = bufferedReader;
    }

    public HostfileProcessor() {
        this.lines = new ArrayList<String>();
        this.ipVersionChecker = new IpVersionChecker(new ContainsIPv4Validator(), new ContainsIPv6Validator());
    }

    public void read(String filename) {
        this.filename = filename;
        this.read();
    }

    public void read() {
        try {
            String line = "bogus";

            while (line != null) {
                line = bufferedReader.readLine();

                if (line != null && !line.isEmpty() && (this.ipVersionChecker.isOrHasIpv4(line) || this.ipVersionChecker.isOrHasIpv6(line))) {
                    this.lines.add(line);
                }
            }

            bufferedReader.close();

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public ArrayList<String> getLines() {
        return this.lines;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (String line : this.lines) {
            if (null != line) {
                sb.append(line);
                sb.append("\n");
            }
        }

        return sb.toString();
    }

    public String getFilename() {
        return this.filename;
    }
}
