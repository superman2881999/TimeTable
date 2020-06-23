package android.app.fragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.R;
import android.app.activity.HomeActivity;
import android.app.activity.LoginActivity;
import android.app.adapters.ItemsAdapter;
import android.app.database.DBHelper;
import android.app.models.Day;
import android.app.models.Timetable2;
import android.app.networks.VolleySingleton;
import android.app.service.AlarmReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;

import static android.content.Context.ALARM_SERVICE;

public class AlarmFragment extends Fragment {

    View view;
    static final String STUDENT_ID = "20173442";
    static final String BASE_URL = "https://bktimetable.azurewebsites.net/api/tables/" + STUDENT_ID;
    private RecyclerView myRecycleView;
    private ArrayList<Timetable2> lsTimetable2;
    private ArrayList<Day> lsDay;
    ItemsAdapter itemsAdapter;
    DBHelper dbHelper;



    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_alarm, container, false);
        dbHelper = new DBHelper(getContext());

        myRecycleView = view.findViewById(R.id.recyclerView);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        lsDay = new ArrayList<>();

        for(int i=2;i<=7;i++){
            lsTimetable2 = new ArrayList<>();
            lsTimetable2.clear();
            lsTimetable2 = dbHelper.getAllSubjects(String.valueOf(i));
            Day day2 = new Day("Thứ "+i ,lsTimetable2);
            lsDay.add(day2);

        }
        itemsAdapter = new ItemsAdapter(lsDay,getContext());

        myRecycleView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                myRecycleView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                itemsAdapter.expandAllGroups();
            }
        });

        myRecycleView.setAdapter(new ScaleInAnimationAdapter(itemsAdapter));

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volleyJsonArrayRequest();

    }

    private void volleyJsonArrayRequest() {
        lsTimetable2 = new ArrayList<>();
        lsDay = new ArrayList<>();
        dbHelper = new DBHelper(getContext());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(BASE_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                try{

                    for(int i=0;i<response.length();i++){
                        JSONObject subject = response.getJSONObject(i);

                        String ma_lop = subject.getString("Ma_Lop");

                        String ten_lop = subject.getString("Ten_Lop");
                        String loai_lop = subject.getString("Loai_Lop");

                        String tg_bat_dau = subject.getString("Bat_Dau");
                        String gio_bat_dau=convertTimeUTC(tg_bat_dau);

                        String tg_ket_thuc = subject.getString("Ket_Thuc");
                        String gio_ket_thuc = convertTimeUTC(tg_ket_thuc);
                        String tuan_hoc = subject.getString("Tuan_Hoc");

                        String phong_hoc = subject.getString("Phong_Hoc");
                        String header = phong_hoc.substring(0,2);
                        String footer = phong_hoc.substring(3);
                        phong_hoc = header+"\n"+footer;

                        String thu = subject.getString("Thu");
                        Timetable2 timetable2;
                        timetable2 = new Timetable2(ma_lop,ten_lop,phong_hoc,gio_bat_dau,gio_ket_thuc,tuan_hoc,loai_lop,thu);
                        if(dbHelper.check_name(timetable2))
                            dbHelper.addTimeTable(timetable2);
                        dbHelper.updateSubject(timetable2);
                        itemsAdapter.notifyDataSetChanged();
                    }

                }catch (JSONException | ParseException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", "JsonArrayRequest onErrorResponse: " + error.getMessage());
            }
        });
        VolleySingleton.getInstance(getContext()).getRequestQueue().add(jsonArrayRequest);
    }
    protected String convertTimeUTC(String inputText)
            throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        SimpleDateFormat outputFormat = new SimpleDateFormat("HH'h'mm");

        Date date = inputFormat.parse(inputText);
        String outputText = outputFormat.format(date);
        return outputText;
    }



}
