package tv.codely.mooc.transfers.domain;

import tv.codely.shared.domain.criteria.Criteria;

import java.util.List;
import java.util.Optional;

public interface TransferRepository {
    void save(Transfer course);

    Optional<Transfer> search(TransferId id);

    List<Transfer> matching(Criteria criteria);
}
