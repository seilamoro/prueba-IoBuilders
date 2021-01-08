package tv.codely.mooc.transfers.domain;

import tv.codely.shared.domain.StringValueObject;

public class TransferAmount extends StringValueObject {
    public TransferAmount(String value) {
        super(value);
    }

    public TransferAmount() {
        super("");
    }
}
