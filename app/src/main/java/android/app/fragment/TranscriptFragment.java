package android.app.fragment;

import android.app.R;
import android.app.adapters.ItemHomeworkAdapter;
import android.app.adapters.ItemTranscriptAdapter;
import android.app.models.transcript;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;

import java.util.ArrayList;
import java.util.List;

public class TranscriptFragment extends Fragment {

    View view;
    private PieChart mChart;
    private RecyclerView rcv_listSubject;
    private List<transcript> listSubject;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_transcript, container, false);
        rcv_listSubject = view.findViewById(R.id.rcv_list);
        mChart = view.findViewById(R.id.piechart);
        final ItemTranscriptAdapter itemHomeworkAdapter = new ItemTranscriptAdapter(listSubject,getContext(),mChart);
        rcv_listSubject.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcv_listSubject.setAdapter(itemHomeworkAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listSubject = new ArrayList<>();
        listSubject.add(new transcript("Thuật toán ứng dụng"));
        listSubject.add(new transcript("Kỹ năng mềm"));
        listSubject.add(new transcript("Phân tích thiết kế hệ thống"));
        listSubject.add(new transcript("Lập trình mạng"));
        listSubject.add(new transcript("Phát triển ứng dụng cho thiết bị di động"));
        listSubject.add(new transcript("An toàn thông tin"));
    }
}
