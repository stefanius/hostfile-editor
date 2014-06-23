package subject;

import observer.pattern.base.Subject;

/**
 * Created by stefanius on 17/06/14.
 */
public class Record extends Subject {

    protected boolean enabled;

    protected String ip;

    protected String hostname;

    public Record(boolean enabled, String ip, String hostname) {
        this.enabled = enabled;
        this.ip = ip;
        this.hostname = hostname;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
