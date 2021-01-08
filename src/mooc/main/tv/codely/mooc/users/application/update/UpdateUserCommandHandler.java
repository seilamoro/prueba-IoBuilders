package tv.codely.mooc.users.application.update;

import tv.codely.mooc.users.domain.*;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.command.CommandHandler;

@Service
public class UpdateUserCommandHandler implements CommandHandler<UpdateUserCommand> {
    private final UserUpdater updater;

    public UpdateUserCommandHandler(UserUpdater updater) {
        this.updater = updater;
    }

    @Override
    public void handle(UpdateUserCommand command) {
        UserId id = new UserId(command.id());
        UserName name = new UserName(command.name());
        UserSurname surname = new UserSurname(command.surname());
        UserMobile mobile = new UserMobile(command.mobile());
        UserPassword password = new UserPassword(command.password());

        updater.update(id, name, surname, mobile, password);
    }
}
