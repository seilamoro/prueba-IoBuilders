package tv.codely.mooc.users.domain;

import tv.codely.shared.domain.StringValueObject;

public class UserName extends StringValueObject {
    public UserName(String value) {
        super(value);
    }

    public UserName() {
        super("");
    }
}
