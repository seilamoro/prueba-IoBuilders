package tv.codely.mooc.users.application;

import tv.codely.mooc.users.domain.User;
import tv.codely.shared.domain.bus.query.Response;

public class UserResponse  implements Response {
    private final String id;
    private final String name;
    private final String surname;
    private final String mobile;
    private final String password;
    private final Boolean active;

    public UserResponse(String id, String name, String surname, String mobile, String password, Boolean active) {
        this.id       = id;
        this.name     = name;
        this.surname  = surname;
        this.mobile   = mobile;
        this.password = password;
        this.active   = active;
    }

    public static UserResponse fromAggregate(User user) {
        return new UserResponse(user.id().value(), user.name().value(), user.surname().value(), user.mobile().value(), user.password().value(), user.active());
    }

    public String id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    public String surname() {
        return this.surname;
    }

    public String mobile() {
        return this.mobile;
    }

    public String password() {
        return this.password;
    }

    public Boolean active(){ return this.active; }
}
