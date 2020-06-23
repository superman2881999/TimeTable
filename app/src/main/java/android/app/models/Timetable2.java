package android.app.models;

import android.os.Parcel;
import android.os.Parcelable;
public class Timetable2 implements Parcelable {


    public final String ma_lop;
    public final String ten_mon_hoc;
    public final String phong_hoc;
    public final String tg_bat_dau;
    public final String tg_ket_thuc;
    public final String tuan_hoc;
    public final String loai_lop;
    public final String thu;


    public Timetable2(String maLop,String tenMonHoc, String phongHoc, String tgBatDau, String tgKetThuc,String tuanHoc, String loaiLop,String thu) {

        this.ma_lop = maLop;
        this.ten_mon_hoc = tenMonHoc;
        this.phong_hoc = phongHoc;
        this.tg_bat_dau = tgBatDau;
        this.tg_ket_thuc = tgKetThuc;
        this.tuan_hoc = tuanHoc;
        this.loai_lop = loaiLop;
        this.thu = thu;
    }

    public String getMa_lop() {
        return ma_lop;
    }

    public String getTen_mon_hoc() {
        return ten_mon_hoc;
    }

    public String getPhong_hoc() {
        return phong_hoc;
    }

    public String getTg_bat_dau() {
        return tg_bat_dau;
    }

    public String getTg_ket_thuc() {
        return tg_ket_thuc;
    }

    public String getTuan_hoc() {
        return tuan_hoc;
    }

    public String getLoai_lop() {
        return loai_lop;
    }

    public String getThu() {
        return thu;
    }

    protected Timetable2(Parcel in) {
        ma_lop = in.readString();
        ten_mon_hoc = in.readString();
        phong_hoc = in.readString();
        tg_bat_dau = in.readString();
        tg_ket_thuc = in.readString();
        tuan_hoc = in.readString();
        loai_lop = in.readString();
        thu = in.readString();
    }



    public static final Creator<Timetable2> CREATOR = new Creator<Timetable2>() {
        @Override
        public Timetable2 createFromParcel(Parcel in) {
            return new Timetable2(in);
        }

        @Override
        public Timetable2[] newArray(int size) {
            return new Timetable2[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ma_lop);
        dest.writeString(ten_mon_hoc);
        dest.writeString(phong_hoc);
        dest.writeString(tg_bat_dau);
        dest.writeString(tg_ket_thuc);
        dest.writeString(tuan_hoc);
        dest.writeString(loai_lop);
        dest.writeString(thu);
    }
}
