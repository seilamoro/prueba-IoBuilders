package tv.codely.mooc.users.domain;

import tv.codely.shared.domain.DomainError;

public final class UserNotExist extends DomainError {
    public UserNotExist(UserId id) {
        super("user_not_exist", String.format("The user <%s> doesn't exist", id.value()));
    }
}

