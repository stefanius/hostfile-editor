package extractors;

import interfaces.IExtractor;
import interfaces.IValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by stefanius on 09/06/14.
 */
public class IPv4Extractor implements IExtractor {

    public String extract(String s)
    {
        if (s == null) {
            return "";
        }

        if (s.isEmpty()) {
            return "";
        }

        return this.extractIPv4(s);
    }

    protected String extractIPv4(String s)
    {
        String ipv4Regex = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern pattern = Pattern.compile(ipv4Regex);
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            return matcher.group();
        } else {
            return "";
        }

    }
}
