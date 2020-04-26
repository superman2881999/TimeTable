package android.app.models;


import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

public class Timetable  {

    String tvDay;
    String tvSubject;
    String tvRoom;
    String timeStart;
    String timeEnd;
    public  Timetable() {

    }

    public Timetable(String tvDay, String tvSubject, String tvRoom, String timeStart, String timeEnd) {
        this.tvDay = tvDay;
        this.tvSubject = tvSubject;
        this.tvRoom = tvRoom;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public void parseTimetable(JSONObject time) throws JSONException {
        this.tvDay = time.getString("Thu");
        this.tvSubject = time.getString("Ten_Lop");
        this.tvRoom = time.getString("Phong_Hoc");
        this.timeStart = time.getString("Bat_Dau");
        this.timeEnd = time.getString("Ket_Thuc");
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

    @Override
    public String toString() {
        return "tvDay: " + this.getTvDay() + "tvSubject" + this.getTvSubject();
    }
}
