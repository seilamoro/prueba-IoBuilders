package tv.codely.apps.mooc.backend.controller.courses;

final class Request {
    private String name;
    private String duration;

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }

    String duration() {
        return duration;
    }
}
