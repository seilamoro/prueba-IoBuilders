package tv.codely.mooc.users.application.delete;

import tv.codely.mooc.users.application.update.UserUpdater;
import tv.codely.mooc.users.domain.*;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.command.CommandHandler;

@Service
public class DeleteUserCommandHandler implements CommandHandler<DeleteUserCommand> {
    private final UserDeleter deleter;

    public DeleteUserCommandHandler(UserDeleter deleter) {
        this.deleter = deleter;
    }

    @Override
    public void handle(DeleteUserCommand command) {
        UserId id = new UserId(command.id());

        deleter.delete(id);
    }
}
