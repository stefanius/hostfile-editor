package validators;

import interfaces.IValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by stefanius on 09/06/14.
 */
public class ContainsIPv4Validator implements IValidator {

    public boolean validate(String s)
    {
        if (s == null) {
            return false;
        }

        if (s.isEmpty()) {
            return false;
        }

        return this.matchIPv4(s);
    }

    protected boolean matchIPv4(String s)
    {
        String ipv4Regex = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern pattern = Pattern.compile(ipv4Regex);
        Matcher matcher = pattern.matcher(s);

        return matcher.find();
    }
}
