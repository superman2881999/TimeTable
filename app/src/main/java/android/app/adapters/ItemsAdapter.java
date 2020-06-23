package android.app.adapters;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.R;
import android.app.models.Day;
import android.app.models.Timetable2;
import android.app.service.AlarmReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.Date;
import java.util.List;

import static android.content.Context.ALARM_SERVICE;

public class ItemsAdapter extends ExpandableRecyclerViewAdapter<ListSubjectViewHolder, SubjectViewHolder> {

    List<? extends ExpandableGroup> grupo;
    Context mContext;
    LayoutInflater mInflater;
    AlarmManager alarmManager;

    public ItemsAdapter(List<? extends ExpandableGroup> groups, Context context) {
        super(groups);
        grupo = groups;
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public ListSubjectViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_group, parent, false);
        return new ListSubjectViewHolder(v);

    }

    @Override
    public SubjectViewHolder onCreateChildViewHolder(final ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_child, parent, false);
        final SubjectViewHolder mViewHolder = new SubjectViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               displayAlertDialog();
            }
        });
        return mViewHolder;
    }

    @Override
    public void onBindChildViewHolder(SubjectViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Timetable2 timetable2 = (Timetable2) group.getItems().get(childIndex);
        holder.bind(timetable2);

    }

    @Override
    public void onBindGroupViewHolder(ListSubjectViewHolder holder, int flatPosition, ExpandableGroup group) {
        final Day day = (Day) group;
        holder.bind(day);
    }
    public void expandAllGroups(){

        for(int i = 0;i<grupo.size();i++){
            if (!isGroupExpanded(grupo.get(i))) {
                onGroupClick(expandableList.getFlattenedGroupIndex(i));
            }
        }
    }
    public void displayAlertDialog() {
        View alertLayout = mInflater.inflate(R.layout.custom_dialog,null);
        final EditText edt = alertLayout.findViewById(R.id.edt_ghi_chu);
        final TimePicker tp = alertLayout.findViewById(R.id.time_picker);

        AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
        alert.setTitle("Đặt Báo Thức");
        alert.setView(alertLayout);
        alert.setCancelable(false);
        alert.setNegativeButton("Huỷ", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(mContext, "Đã huỷ", Toast.LENGTH_SHORT).show();
            }
        });

        alert.setPositiveButton("Đặt", new DialogInterface.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(mContext, "Đặt báo thức thành công",Toast.LENGTH_SHORT).show();
               int hour = tp.getHour();
               int minutes = tp.getMinute();
                final String ghi_chu = edt.getText().toString();
                java.util.Date date=new java.util.Date(120,5,23,hour,minutes,00);

                setNofication(date,ghi_chu);
            }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }
    void setNofication( Date date,String ghi_chu) {
        alarmManager = (AlarmManager)mContext.getSystemService(ALARM_SERVICE);

        Log.e("TAG", "Đã đặt báo thức lúc" + date.getHours() +":"+ date.getMinutes()+":"+date.getSeconds());

        Intent intent = new Intent(mContext, AlarmReceiver.class);
        intent.putExtra("ghi_chu",ghi_chu);
        Log.v("TAG2",ghi_chu);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, date.getTime(), pendingIntent);
    }
}
