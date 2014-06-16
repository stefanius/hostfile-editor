package extractors;

import interfaces.IExtractor;

import java.lang.reflect.Array;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by stefanius on 09/06/14.
 */
public class HostnameFromHostfileExtractor implements IExtractor {

    public String extract(String s)
    {
        if (s == null) {
            return "";
        }

        if (s.isEmpty()) {
            return "";
        }

        s = s.replace(this.extractIPv4(s), "");
        s = s.replace(this.extractIPv6(s), "");

        char[] charArray = s.toCharArray();
        char[] hostname = new char[charArray.length];

        int i = 0;

        for(char c : charArray) {
            if (c == '#' && i > 0) {
                break;
            }

            if (c != '#') {
                hostname[i] = c;
            }

            i++;

        }

        return new String(hostname).trim();
    }

    protected String extractIPv4(String s)
    {
        String ipv4Regex = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern pattern = Pattern.compile(ipv4Regex);
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            return matcher.group();
        }else {
            return "";
        }
    }

    protected String extractIPv6(String s)
    {
        String ipv6Regex = "(?:" +
                "([0-9a-fA-F]{4}::[0-9]) |" +
                "([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|" +
                "([0-9a-fA-F]{1,4}:){1,7}:|" +
                "([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|" +
                "([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|" +
                "([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|" +
                "([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|" +
                "([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|" +
                "[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|" +
                ":((:[0-9a-fA-F]{1,4}){1,7}|:)|" +
                "fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|" +
                "::(ffff(:0{1,4}){0,1}:){0,1}" +
                "((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]).){3,3}" +
                "(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|" +
                "([0-9a-fA-F]{1,4}:){1,4}:" +
                "((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]).){3,3}|" +
                "(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]):" +
                "?)";

        Pattern pattern = Pattern.compile(ipv6Regex);
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            return matcher.group();
        }else {
            return "";
        }
    }
}
