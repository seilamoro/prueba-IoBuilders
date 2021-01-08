package tv.codely.mooc.transfers.domain;

import tv.codely.shared.domain.StringValueObject;

public class TransferDate extends StringValueObject {
    public TransferDate(String value) {
        super(value);
    }

    public TransferDate() {
        super("");
    }
}
