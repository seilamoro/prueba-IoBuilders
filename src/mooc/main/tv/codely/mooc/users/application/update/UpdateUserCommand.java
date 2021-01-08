package tv.codely.mooc.users.application.update;

import tv.codely.shared.domain.bus.command.Command;

public class UpdateUserCommand implements Command {
    private final String id;
    private final String name;
    private final String surname;
    private final String mobile;
    private final String password;

    public UpdateUserCommand(String id, String name, String surname, String mobile, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mobile = mobile;
        this.password = password;
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
}
