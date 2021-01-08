package tv.codely.mooc.users.application.delete;

import tv.codely.shared.domain.bus.command.Command;

public class DeleteUserCommand implements Command {
    private final String id;

    public DeleteUserCommand(String id) {
        this.id = id;
    }

    public String id() {
        return this.id;
    }
}
