package tv.codely.mooc.users.domain;

import tv.codely.shared.domain.StringValueObject;

public class UserPassword extends StringValueObject {
    public UserPassword(String value) {
        super(value);
    }

    public UserPassword() {
        super("");
    }
}
