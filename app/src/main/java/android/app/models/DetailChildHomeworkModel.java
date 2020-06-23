package android.app.models;

import android.os.Parcel;
import android.os.Parcelable;

public class DetailChildHomeworkModel implements Parcelable {


    public final String name_homework;

    public String getName_homework() {
        return name_homework;
    }

    public DetailChildHomeworkModel(String nameHomework) {
        this.name_homework = nameHomework;

    }

    protected DetailChildHomeworkModel(Parcel in) {
        name_homework = in.readString();
    }



    public static final Creator<DetailChildHomeworkModel> CREATOR = new Creator<DetailChildHomeworkModel>() {
        @Override
        public DetailChildHomeworkModel createFromParcel(Parcel in) {
            return new DetailChildHomeworkModel(in);
        }

        @Override
        public DetailChildHomeworkModel[] newArray(int size) {
            return new DetailChildHomeworkModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name_homework);

    }
}