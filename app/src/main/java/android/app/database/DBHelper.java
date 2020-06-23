package android.app.database;

import android.app.models.Timetable2;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASENAME = "TimeTable.db";
    public static final int VERSION = 1;
    public static final String COMA_SEP = ",";
    //column of meeting table
    public static final String TABLE_THOI_KHOA_BIEU = "Thoi_khoa_bieu";
    public static final String COLUMN_SUBJECT_ID = "Subject_id";
    public static final String COLUMN_TEN_MON_HOC = "Ten_mon_hoc";
    public static final String COLUMN_PHONG_HOC = "Phong_hoc";
    public static final String COLUMN_TG_BAT_DAU = "Tg_bat_dau";
    public static final String COLUMN_TG_KET_THUC = "Tg_ket_thuc";
    public static final String COLUMN_MA_LOP = "Ma_lop";
    public static final String COLUMN_LOAI_LOP = "Loai_lop";
    public static final String COLUMN_TUAN_HOC = "Tuan_hoc";
    public static final String COLUMN_THU = "Thu";


    //create table meeting
    public static final String SQLITE_CREATE_TABLE_MEETING = "CREATE TABLE " + TABLE_THOI_KHOA_BIEU + " (Subject_ID INTEGER PRIMARY KEY " +
            "AUTOINCREMENT" + COMA_SEP +
            COLUMN_TEN_MON_HOC + " TEXT" + COMA_SEP +
            COLUMN_PHONG_HOC + " TEXT" + COMA_SEP +
            COLUMN_TG_BAT_DAU + " TEXT" + COMA_SEP +
            COLUMN_TG_KET_THUC + " TEXT" + COMA_SEP +
            COLUMN_MA_LOP + " TEXT" + COMA_SEP +
            COLUMN_LOAI_LOP + " INTEGER" + COMA_SEP +
            COLUMN_TUAN_HOC + " INTEGER" + COMA_SEP +
            COLUMN_THU + " TEXT)";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASENAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLITE_CREATE_TABLE_MEETING);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {

        db.execSQL("PRAGMA foreign_keys=ON");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_THOI_KHOA_BIEU);
        onCreate(db);
    }

    public void addTimeTable(Timetable2 timetable) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TEN_MON_HOC, timetable.getTen_mon_hoc());
        values.put(COLUMN_PHONG_HOC, timetable.getPhong_hoc());
        values.put(COLUMN_TG_BAT_DAU, timetable.getTg_bat_dau());
        values.put(COLUMN_TG_KET_THUC, timetable.getTg_ket_thuc());
        values.put(COLUMN_MA_LOP, timetable.getMa_lop());
        values.put(COLUMN_LOAI_LOP, timetable.getLoai_lop());
        values.put(COLUMN_TUAN_HOC, timetable.getTuan_hoc());
        values.put(COLUMN_THU, timetable.getThu());

        db.insert(TABLE_THOI_KHOA_BIEU, null, values);
        db.close();
    }

    public ArrayList<Timetable2> getAllSubjects(String thu) {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Timetable2> subjectList = new ArrayList<>();

        Cursor cursor = db.query(TABLE_THOI_KHOA_BIEU, null, COLUMN_THU + " = ?", new String[]{thu}, null, null, null);
        cursor.moveToFirst();

        while (cursor.isAfterLast() == false) {
            Timetable2 timetable = new Timetable2(cursor.getString(5), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(7), cursor.getString(6), cursor.getString(8));
            subjectList.add(timetable);
            cursor.moveToNext();
        }
        return subjectList;
    }

    public boolean check_name(Timetable2 timetable) {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_THOI_KHOA_BIEU, null, COLUMN_MA_LOP + " = ?", new String[]{timetable.getMa_lop()}, null, null, null);

        if(cursor.getCount()==0){
            return true;
        }
        return false;
    }
    public void updateSubject(Timetable2 timetable) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TEN_MON_HOC, timetable.getTen_mon_hoc());
        values.put(COLUMN_PHONG_HOC, timetable.getPhong_hoc());
        values.put(COLUMN_TG_BAT_DAU, timetable.getTg_bat_dau());
        values.put(COLUMN_TG_KET_THUC, timetable.getTg_ket_thuc());
        values.put(COLUMN_MA_LOP, timetable.getMa_lop());
        values.put(COLUMN_LOAI_LOP, timetable.getLoai_lop());
        values.put(COLUMN_TUAN_HOC, timetable.getTuan_hoc());
        values.put(COLUMN_THU, timetable.getThu());

        db.update(TABLE_THOI_KHOA_BIEU, values, COLUMN_MA_LOP + " = ?", new String[] { String.valueOf(timetable.getMa_lop()) });
        db.close();
    }

}
