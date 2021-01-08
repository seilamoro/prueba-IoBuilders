package tv.codely.mooc.accounts.infrastructure;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.accounts.domain.Account;
import tv.codely.mooc.accounts.domain.AccountNumber;
import tv.codely.mooc.accounts.domain.AccountRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.criteria.Criteria;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("mooc-transaction_manager")
public class MySqlAccountRepository extends HibernateRepository<Account> implements AccountRepository {
    public MySqlAccountRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Account.class);
    }

    @Override
    public void save(Account account) {
        persist(account);
    }

    @Override
    public Optional<Account> search(AccountNumber number) {
        return byId(number);
    }

    @Override
    public List<Account> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
