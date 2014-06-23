package switchChecker;

import interfaces.ISwitchChecker;
import interfaces.IValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by stefanius on 09/06/14.
 */
public class HashtagCommentSwitch implements ISwitchChecker {

    public boolean check(String s)
    {
        if (s == null) {
            return false;
        }

        if (s.isEmpty()) {
            return false;
        }

        if (s.charAt(0) == '#') {
            return false;
        }

        return true;
    }
}
