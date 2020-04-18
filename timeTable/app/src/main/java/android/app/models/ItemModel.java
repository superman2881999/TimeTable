package android.app.models;


public class ItemModel  {

    String tvDay;
    String tvSubject;
    String tvRoom;
    String timeStart;
    String timeEnd;

    public ItemModel(String tvDay, String tvSubject, String tvRoom, String timeStart, String timeEnd) {
        this.tvDay = tvDay;
        this.tvSubject = tvSubject;
        this.tvRoom = tvRoom;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public String getTvDay() {
        return tvDay;
    }

    public void setTvDay(String tvDay) {
        this.tvDay = tvDay;
    }

    public String getTvSubject() {
        return tvSubject;
    }

    public void setTvSubject(String tvSubject) {
        this.tvSubject = tvSubject;
    }

    public String getTvRoom() {
        return tvRoom;
    }

    public void setTvRoom(String tvRoom) {
        this.tvRoom = tvRoom;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
