package android.app.models;

import android.app.models.Timetable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Timetables {

    private List<Timetable> timetables = new ArrayList() ;
    public  Timetables() {

    }

    public void parseTimetables(JSONArray times) throws JSONException {
        ArrayList<Timetable> temp = new ArrayList<Timetable>();
        for(int i = 0; i < times.length(); i++) {
            Timetable newTimetable = new Timetable();
            newTimetable.parseTimetable(times.getJSONObject(i));
            temp.add(newTimetable);
        }
        this.timetables = temp;
    }

    public List<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(List<Timetable> timetables) {
        this.timetables = timetables;
    }


}

