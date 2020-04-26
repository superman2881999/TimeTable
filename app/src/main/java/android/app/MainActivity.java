package android.app;

import android.annotation.SuppressLint;
import android.app.adapters.KteamAdapter;
import android.app.models.Timetable;
import android.app.models.Timetables;
import android.app.networks.APIRequest;
import android.app.networks.VolleyCallback;
import android.os.Bundle;

import android.app.R;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {


    static final String STUDENT_ID = "20173442";
    static final String BASE_URL = "https://bktimetable.azurewebsites.net/api/tables/"+STUDENT_ID;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        APIRequest reqTimeTable = new APIRequest(BASE_URL, this);
        final Timetables timetables = new Timetables();
        reqTimeTable.req(new VolleyCallback() {
            @Override
            public void onSuccess(JSONArray result) throws JSONException {
                timetables.parseTimetables(result);
                RecyclerView.Adapter adapter = new KteamAdapter(timetables.getTimetables());
                recyclerView.setAdapter(adapter);
            }
        });

    }
}
