package tv.codely.mooc.users.application.create;

import tv.codely.mooc.users.domain.*;
import tv.codely.shared.domain.Service;

@Service
public class UserCreator {
    private final UserRepository repository;

    public UserCreator(UserRepository repository) {
        this.repository = repository;
    }

    public void create(UserId id, UserName name, UserSurname surname, UserMobile mobile, UserPassword password) {
        User user = User.create(id, name, surname, mobile, password);

        repository.save(user);
    }
}
