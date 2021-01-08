package tv.codely.mooc.users.infrastructure;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.users.domain.User;
import tv.codely.mooc.users.domain.UserId;
import tv.codely.mooc.users.domain.UserRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.criteria.Criteria;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("mooc-transaction_manager")
public class MySqlUserRepository extends HibernateRepository<User> implements UserRepository {
    public MySqlUserRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, User.class);
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public Optional<User> search(UserId id) {
        return byId(id);
    }

    @Override
    public List<User> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
