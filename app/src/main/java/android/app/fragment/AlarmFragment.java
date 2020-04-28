package android.app.fragment;

import android.app.R;
import android.app.adapters.ItemsAdapter;
import android.app.models.Timetable;
import android.app.models.Timetables;
import android.app.networks.APIRequest;
import android.app.networks.VolleyCallback;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;

public class AlarmFragment extends Fragment {

    View view;
    static final String STUDENT_ID = "20173442";
    static final String BASE_URL = "https://bktimetable.azurewebsites.net/api/tables/"+STUDENT_ID;
    private RecyclerView myRecycleView;
    private List<Timetable> lsTimetable;

    public AlarmFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_alarm, container, false);
        myRecycleView = view.findViewById(R.id.recyclerView);
        ItemsAdapter itemsAdapter = new ItemsAdapter(lsTimetable);
        myRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecycleView.setAdapter(itemsAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        APIRequest reqTimeTable = new APIRequest(BASE_URL, getActivity());
        final Timetables timetables = new Timetables();
        reqTimeTable.req(new VolleyCallback() {
            @Override
            public void onSuccess(JSONArray result) throws JSONException {
                timetables.parseTimetables(result);
            }
        });
        lsTimetable = timetables.getTimetables();
    }
}
