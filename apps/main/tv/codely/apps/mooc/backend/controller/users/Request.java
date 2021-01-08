package tv.codely.apps.mooc.backend.controller.users;

final class Request {
    private String id;
    private String name;
    private String surname;
    private String mobile;
    private String password;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String id() {
        return this.id;
    }

    String name() {
        return this.name;
    }

    String surname() {
        return this.surname;
    }

    String mobile() {
        return this.mobile;
    }

    String password() {
        return this.password;
    }
}
