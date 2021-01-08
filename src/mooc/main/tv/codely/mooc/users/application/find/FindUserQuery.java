package tv.codely.mooc.users.application.find;

import tv.codely.shared.domain.bus.query.Query;

public final class FindUserQuery implements Query {
    private final String id;
    private final String password;

    public FindUserQuery(String id) {
        this.id = id;
        this.password = "";
    }

    public FindUserQuery(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String id() {
        return this.id;
    }

    public String password() {
        return this.password;
    }
}
