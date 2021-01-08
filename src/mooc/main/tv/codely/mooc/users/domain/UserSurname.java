package tv.codely.mooc.users.domain;

import tv.codely.shared.domain.StringValueObject;

public class UserSurname extends StringValueObject {
    public UserSurname(String value) {
        super(value);
    }

    public UserSurname() {
        super("");
    }
}
