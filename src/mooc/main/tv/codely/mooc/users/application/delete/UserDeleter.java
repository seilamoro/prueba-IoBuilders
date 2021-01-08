package tv.codely.mooc.users.application.delete;

import tv.codely.mooc.users.domain.*;
import tv.codely.shared.domain.Service;

@Service
public class UserDeleter {
    private final UserRepository repository;

    public UserDeleter(UserRepository repository) {
        this.repository = repository;
    }

    public void delete(UserId id) throws UserNotExist {
        User user = repository.search(id)
            .orElseThrow(() -> new UserNotExist(id));

        User userDelete = User.create(id, user.name(), user.surname(), user.mobile(), user.password(), false);

        repository.save(userDelete);
    }
}
