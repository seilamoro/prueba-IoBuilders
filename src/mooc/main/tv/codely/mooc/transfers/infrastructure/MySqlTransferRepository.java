package tv.codely.mooc.transfers.infrastructure;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import tv.codely.mooc.transfers.domain.Transfer;
import tv.codely.mooc.transfers.domain.TransferId;
import tv.codely.mooc.transfers.domain.TransferRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.criteria.Criteria;
import tv.codely.shared.infrastructure.hibernate.HibernateRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional("mooc-transaction_manager")
public class MySqlTransferRepository extends HibernateRepository<Transfer> implements TransferRepository {
    public MySqlTransferRepository(@Qualifier("mooc-session_factory") SessionFactory sessionFactory) {
        super(sessionFactory, Transfer.class);
    }

    @Override
    public void save(Transfer transfer) {
        persist(transfer);
    }

    @Override
    public Optional<Transfer> search(TransferId id) {
        return byId(id);
    }

    @Override
    public List<Transfer> matching(Criteria criteria) {
        return byCriteria(criteria);
    }
}
