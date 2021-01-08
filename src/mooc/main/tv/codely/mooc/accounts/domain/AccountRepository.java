package tv.codely.mooc.accounts.domain;

import tv.codely.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    void save(Account course);

    Optional<Account> search(AccountNumber id);

    List<Account> matching(Criteria criteria);
}
