package tv.codely.mooc.accounts.domain;

import tv.codely.shared.domain.StringValueObject;

public class AccountAmount extends StringValueObject {
    public AccountAmount(String value) {
        super(value);
    }

    public AccountAmount() {
        super("");
    }
}
