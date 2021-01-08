package tv.codely.mooc.users.application.update;

import tv.codely.mooc.users.domain.*;
import tv.codely.shared.domain.Service;

@Service
public class UserUpdater {
    private final UserRepository repository;

    public UserUpdater(UserRepository repository) {
        this.repository = repository;
    }

    public void update(UserId id, UserName name, UserSurname surname, UserMobile mobile, UserPassword password) throws UserNotExist {
        User user = repository.search(id)
            .orElseThrow(() -> new UserNotExist(id));

        User userUpdate = User.create(id, name, surname, mobile, password);

        repository.save(userUpdate);
    }
}
