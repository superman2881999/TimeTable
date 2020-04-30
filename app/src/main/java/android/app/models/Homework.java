package android.app.models;

public class Homework {
    String Classname;
    public Homework(String classname) {
        this.Classname = classname;
    }
    public String getClassname() {
        return Classname;
    }
    public void setClassname(String classname) {
        Classname = classname;
    }
}
