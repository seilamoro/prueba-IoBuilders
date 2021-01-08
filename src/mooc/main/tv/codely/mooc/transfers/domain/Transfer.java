package tv.codely.mooc.transfers.domain;

import tv.codely.shared.domain.AggregateRoot;

import java.util.Objects;
//import tv.codely.shared.domain.course.CourseCreatedDomainEvent; TODO

public class Transfer extends AggregateRoot {
    private final TransferId id;
    private final TransferDate date;
    private final TransferTime time;
    private final TransferAccountOrigin accountOrigin;
    private final TransferAccountDestiny accountDestiny;
    private final TransferAmount amount;
    private final TransferConcept concept;

    public Transfer(TransferId id, TransferDate date, TransferTime time, TransferAccountOrigin accountOrigin, TransferAccountDestiny accountDestiny, TransferAmount amount, TransferConcept concept) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.accountOrigin = accountOrigin;
        this.accountDestiny = accountDestiny;
        this.amount = amount;
        this.concept = concept;
    }

    private Transfer() {
        this.id = null;
        this.date = null;
        this.time = null;
        this.accountOrigin = null;
        this.accountDestiny = null;
        this.amount = null;
        this.concept = null;
    }

    public static Transfer create(TransferId id, TransferDate date, TransferTime time, TransferAccountOrigin accountOrigin, TransferAccountDestiny accountDestiny, TransferAmount amount, TransferConcept concept) {
        Transfer transfer = new Transfer(id, date, time, accountOrigin, accountDestiny, amount, concept);

        //user.record(new CourseCreatedDomainEvent(id.value(), name.value(), duration.value())); //TODO: QUE ES ESTO???

        return transfer;
    }

    public TransferId id() {
        return this.id;
    }

    public TransferDate date() {
        return this.date;
    }

    public TransferTime time() {
        return this.time;
    }

    public TransferAccountOrigin accountOrigin() {
        return this.accountOrigin;
    }

    public TransferAccountDestiny accountDestiny() {
        return this.accountDestiny;
    }

    public TransferAmount amount() {
        return this.amount;
    }

    public TransferConcept concept() {
        return this.concept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transfer transfer = (Transfer) o;
        return id.equals(transfer.id) &&
            date.equals(transfer.date) &&
            time.equals(transfer.time); //TODO: PONER TODOS LOS CAMPOS
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.date, this.time);
    }
}
