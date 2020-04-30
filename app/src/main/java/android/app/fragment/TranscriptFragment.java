package android.app.fragment;

import android.app.R;
import android.app.adapters.ItemsAdapter;
import android.app.adapters.ItemsTranscriptAdapter;
import android.app.models.Timetable;
import android.app.models.Timetables;
import android.app.models.Transcript;
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

public class TranscriptFragment extends Fragment {
    View view;
    private RecyclerView rcv_Transcript;
    private List<Transcript> lsTrans;

    public TranscriptFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_transcript, container, false);
        rcv_Transcript = view.findViewById(R.id.rcv_transcript);
        ItemsTranscriptAdapter itemsTranscriptAdapter = new ItemsTranscriptAdapter(lsTrans);
        rcv_Transcript.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcv_Transcript.setAdapter(itemsTranscriptAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lsTrans = new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i <=10; i++){
            lsTrans.add(new Transcript(faker.name.name(),faker.number.number(10)));
        }
    }
}
