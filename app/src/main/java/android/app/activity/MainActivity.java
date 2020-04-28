package android.app.activity;

import android.app.R;
import android.app.adapters.ItemsAdapter;
import android.app.models.Timetables;
import android.app.networks.APIRequest;
import android.app.networks.VolleyCallback;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {


    static final String STUDENT_ID = "20173442";
    static final String BASE_URL = "https://bktimetable.azurewebsites.net/api/tables/"+STUDENT_ID;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_alarm);
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

                RecyclerView.Adapter adapter = new ItemsAdapter(timetables.getTimetables());
                recyclerView.setAdapter(adapter);
            }
        });

    }
}
