package tv.codely.mooc.transfers.domain;

import tv.codely.shared.domain.StringValueObject;

public class TransferTime extends StringValueObject {
    public TransferTime(String value) {
        super(value);
    }

    public TransferTime() {
        super("");
    }
}
