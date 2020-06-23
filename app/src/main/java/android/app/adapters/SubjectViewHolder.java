package android.app.adapters;

import android.app.R;
import android.app.models.Timetable2;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class SubjectViewHolder extends ChildViewHolder {
    private TextView tvPhongHoc;
    private TextView tvMonHocMaLop;
    private TextView tvThoiGianTuanHoc;
    private TextView tvLoaiLop;

    public SubjectViewHolder(View itemView) {
        super(itemView);
        tvPhongHoc = itemView.findViewById(R.id.tv_phong_hoc);
        tvMonHocMaLop = itemView.findViewById(R.id.tv_mon_hoc_ma_lop);
        tvThoiGianTuanHoc = itemView.findViewById(R.id.tv_thoi_gian_tuan_hoc);
        tvLoaiLop = itemView.findViewById(R.id.tv_loai_lop);

    }

    public void bind(Timetable2 timetable) {

        tvPhongHoc.setText(timetable.phong_hoc);
        tvMonHocMaLop.setText("[" + timetable.ma_lop + "] " + timetable.ten_mon_hoc);
        tvThoiGianTuanHoc.setText(timetable.tg_bat_dau+" - "+ timetable.tg_ket_thuc+" ("+ timetable.tuan_hoc+")");
        tvLoaiLop.setText(timetable.loai_lop);


    }

}