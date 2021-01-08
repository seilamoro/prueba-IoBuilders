package tv.codely.mooc.users.application.find;

import tv.codely.mooc.users.application.UserResponse;
import tv.codely.mooc.users.domain.UserId;
import tv.codely.mooc.users.domain.UserNotExist;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.query.QueryHandler;

@Service
public final class FindUserQueryHandler implements QueryHandler<FindUserQuery, UserResponse> {
    private final UserFinder finder;

    public FindUserQueryHandler(UserFinder finder) {
        this.finder = finder;
    }

    @Override
    public UserResponse handle(FindUserQuery query) throws UserNotExist {
        return finder.find(new UserId(query.id()));
    }
}
