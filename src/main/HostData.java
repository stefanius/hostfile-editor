package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by stefanius on 10/06/14.
 */
public class HostData {

    protected ArrayList<Row> rows;

    public HostData()
    {
        this.rows = new ArrayList< Row>();
    }

    public void addRow(boolean enabled, String ip, String host)
    {
        Row row = new Row();

        row.setEnabled(enabled);
        row.setIp(ip);
        row.setHost(host);

        this.rows.add(row);
    }

    public ArrayList<Row> getRows()
    {
        return this.rows;
    }

    public Row getRow(String key)
    {
        return null;
    }
}
