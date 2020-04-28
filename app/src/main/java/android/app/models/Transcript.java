package android.app.models;

public class Transcript {
    String tv_subject;
    String tv_point;

    public String getTv_subject() {
        return tv_subject;
    }

    public void setTv_subject(String tv_subject) {
        this.tv_subject = tv_subject;
    }

    public String getTv_point() {
        return tv_point;
    }

    public void setTv_point(String tv_point) {
        this.tv_point = tv_point;
    }

    public Transcript(String tv_subject, String tv_point) {
        this.tv_subject = tv_subject;
        this.tv_point = tv_point;
    }
}
