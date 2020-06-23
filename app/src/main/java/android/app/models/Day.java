package android.app.models;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Day extends ExpandableGroup<Timetable2> {

    public Day(String title, List<Timetable2> items) {
        super(title, items);
    }
}
