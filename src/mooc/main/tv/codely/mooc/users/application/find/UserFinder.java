package tv.codely.mooc.users.application.find;

import tv.codely.mooc.users.application.UserResponse;
import tv.codely.mooc.users.domain.UserId;
import tv.codely.mooc.users.domain.UserNotExist;
import tv.codely.mooc.users.domain.UserPassword;
import tv.codely.mooc.users.domain.UserRepository;
import tv.codely.shared.domain.Service;

@Service
public final class UserFinder {
    private final UserRepository repository;

    public UserFinder(UserRepository repository) {
        this.repository = repository;
    }

    public UserResponse find(UserId id) throws UserNotExist {
        UserResponse user = repository.search(id)
            .map(UserResponse::fromAggregate)
            .orElseThrow(() -> new UserNotExist(id));
        if(user.active()) {
            return user;
        }
        else {
            throw new UserNotExist(id);
        }
    }

    public UserResponse find(UserId id, UserPassword password) throws UserNotExist {
        UserResponse user = repository.search(id)
            .map(UserResponse::fromAggregate)
            .orElseThrow(() -> new UserNotExist(id));
        if(user.active() && user.password().equals(password)) {
            return user;
        }
        else {
            throw new UserNotExist(id);
        }
    }
}

