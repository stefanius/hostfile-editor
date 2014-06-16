package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by stefanius on 09/06/14.
 */
public class StringReader {

    protected ArrayList<String> lines;

    protected String filename;

    public StringReader()
    {
        this.lines = new ArrayList<String>();
    }

    public StringReader(String filename) {
        this();
        this.filename = filename;
    }

    public void read(String filename)
    {
        this.filename = filename;
        this.read();
    }

    public void read()
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.filename));
            StringBuilder sb = new StringBuilder();
            String line = "bogus";

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
                this.lines.add(line);
            }

            br.close();

        }catch (Exception e){
            System.out.print(e);
        }
    }

    public ArrayList<String> getLines() {
        return this.lines;
    }

    @Override
    public String toString() {

        StringBuffer buffer = new StringBuffer();

        for(String line : this.lines){
            if(null != line){
                buffer.append(line);
                buffer.append("\n");
            }
        }

        return buffer.toString();
    }

    public String getFilename() {
        return this.filename;
    }
}
