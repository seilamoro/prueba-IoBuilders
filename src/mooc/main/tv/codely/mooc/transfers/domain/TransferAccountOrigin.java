package tv.codely.mooc.transfers.domain;

import tv.codely.shared.domain.StringValueObject;

public class TransferAccountOrigin extends StringValueObject {
    public TransferAccountOrigin(String value) {
        super(value);
    }

    public TransferAccountOrigin() {
        super("");
    }
}
