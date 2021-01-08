package tv.codely.mooc.users.application.create;

import tv.codely.mooc.users.domain.*;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.command.CommandHandler;

@Service
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {
    private final UserCreator creator;

    public CreateUserCommandHandler(UserCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateUserCommand command) {
        UserId id = new UserId(command.id());
        UserName name = new UserName(command.name());
        UserSurname surname = new UserSurname(command.surname());
        UserMobile mobile = new UserMobile(command.mobile());
        UserPassword password = new UserPassword(command.password());

        creator.create(id, name, surname, mobile, password);
    }
}
