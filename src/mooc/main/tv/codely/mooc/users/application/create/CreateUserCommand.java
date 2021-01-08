package tv.codely.mooc.users.application.create;

import tv.codely.shared.domain.bus.command.Command;

public final class CreateUserCommand implements Command {
    private final String id;
    private final String name;
    private final String surname;
    private final String mobile;
    private final String password;
    private final boolean active;

    public CreateUserCommand(String id, String name, String surname, String mobile, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mobile = mobile;
        this.password = password;
        this.active = true;
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

    public boolean active() {
        return this.active;
    }
}
