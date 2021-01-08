package tv.codely.mooc.users.domain;

import tv.codely.shared.domain.AggregateRoot;
//import tv.codely.shared.domain.course.CourseCreatedDomainEvent; //TODO

import java.util.Objects;

public class User extends AggregateRoot {
    private final UserId id;
    private final UserName name;
    private final UserSurname surname;
    private final UserMobile mobile;
    private final UserPassword password;
    private final boolean active;

    public User(UserId id, UserName name, UserSurname surname, UserMobile mobile, UserPassword password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mobile = mobile;
        this.password = password;
        this.active = true;
    }

    public User(UserId id, UserName name, UserSurname surname, UserMobile mobile, UserPassword password, boolean active) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mobile = mobile;
        this.password = password;
        this.active = active;
    }

    private User() {
        this.id = null;
        this.name = null;
        this.surname = null;
        this.mobile = null;
        this.password = null;
        this.active = true;
    }

    public static User create(UserId id, UserName name, UserSurname surname, UserMobile mobile, UserPassword password) {
        User user = new User(id, name, surname, mobile, password);

        return user;
    }

    public static User create(UserId id, UserName name, UserSurname surname, UserMobile mobile, UserPassword password, boolean active) {
        User user = new User(id, name, surname, mobile, password, active);

        return user;
    }

    public UserId id() {
        return this.id;
    }

    public UserName name() {
        return this.name;
    }

    public UserSurname surname() {
        return this.surname;
    }

    public UserMobile mobile() {
        return this.mobile;
    }

    public UserPassword password() {
        return this.password;
    }

    public boolean active() {
        return this.active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id.equals(user.id) &&
            name.equals(user.name) &&
            surname.equals(user.surname); //TODO: PONER TODOS LOS CAMPOS
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.surname);
    }
}
