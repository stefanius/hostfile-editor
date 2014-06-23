package misc;

import interfaces.IValidator;

/**
 * Created by stefanius on 20/06/14.
 */
public class IpVersionChecker {

    protected IValidator ipv4Validator;

    protected IValidator ipv6Validator;

    public IpVersionChecker(IValidator ipv4Validator, IValidator ipv6Validator) {
        this.ipv4Validator = ipv4Validator;
        this.ipv6Validator = ipv6Validator;
    }

    public boolean isOrHasIpv4(String data){
        return this.ipv4Validator.validate(data);
    }

    public boolean isOrHasIpv6(String data){
        return this.ipv6Validator.validate(data);
    }
}
