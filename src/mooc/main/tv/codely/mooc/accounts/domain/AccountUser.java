package tv.codely.mooc.accounts.domain;

import tv.codely.shared.domain.StringValueObject;

public class AccountUser extends StringValueObject {
    public AccountUser(String value) {
        super(value);
    }

    public AccountUser() {
        super("");
    }
}
