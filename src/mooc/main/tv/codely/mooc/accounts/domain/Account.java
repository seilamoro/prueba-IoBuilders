package tv.codely.mooc.accounts.domain;

import tv.codely.mooc.transfers.domain.*;
import tv.codely.shared.domain.AggregateRoot;

import java.util.Objects;
//import tv.codely.shared.domain.course.CourseCreatedDomainEvent; TODO

public class Account extends AggregateRoot {
    private final AccountNumber number;
    private final AccountAmount amount;
    private final AccountUser user;
    private final boolean active;

    public Account(AccountNumber number, AccountAmount amount, AccountUser user) {
        this.number = number;
        this.amount = amount;
        this.user = user;
        this.active= true;
    }

    public Account() {
        this.number = null;
        this.amount = null;
        this.user = null;
        this.active= true;
    }

    public static Account create(AccountNumber number, AccountAmount amount, AccountUser user) {
        Account account = new Account(number, amount, user);

        //user.record(new CourseCreatedDomainEvent(id.value(), name.value(), duration.value())); //TODO: QUE ES ESTO???

        return account;
    }

    public AccountNumber number() {
        return this.number;
    }

    public AccountAmount amount() {
        return this.amount;
    }

    public AccountUser user() {
        return this.user;
    }

    public boolean active() {
        return this.active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return number.equals(account.number) &&
            amount.equals(account.amount) &&
            user.equals(account.user); //TODO: PONER TODOS LOS CAMPOS
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number, this.amount, this.user);
    }
}
