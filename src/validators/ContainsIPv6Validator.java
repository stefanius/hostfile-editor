package validators;

import interfaces.IValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by stefanius on 09/06/14.
 */
public class ContainsIPv6Validator implements IValidator {

    public boolean validate(String s)
    {
        if (s == null) {
            return false;
        }

        if (s.isEmpty()) {
            return false;
        }

        if (!s.contains(":")) {
            return false;
        }

        return this.matchIPv6(s);
    }

    protected boolean matchIPv6(String s)
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

        return matcher.find();
    }
}
