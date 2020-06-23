package android.app.models;

import android.os.Parcel;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class DetailGroupHomeworkModel extends ExpandableGroup<DetailChildHomeworkModel> {

    public DetailGroupHomeworkModel(String title, List<DetailChildHomeworkModel> items) {
        super(title, items);
    }

    protected DetailGroupHomeworkModel(Parcel in) {
        super(in);
    }

}
