package tv.codely.mooc.users.domain;

import tv.codely.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User course);

    Optional<User> search(UserId id);

    List<User> matching(Criteria criteria);
}
