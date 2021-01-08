package tv.codely.mooc.users.domain;

import tv.codely.shared.domain.StringValueObject;

public class UserMobile extends StringValueObject {
    public UserMobile(String value) {
        super(value);
    }

    public UserMobile() {
        super("");
    }
}
