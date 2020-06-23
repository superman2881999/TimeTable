package android.app.fragment;

import android.app.R;
import android.app.adapters.ItemHomeworkAdapter;
import android.app.models.Homework;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;

public class HomeworkFragment extends Fragment {
    View view;
    private RecyclerView rcv_HomeWork;
    private List<Homework> lsHomework;
    public HomeworkFragment() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_homework, container, false);
        rcv_HomeWork = view.findViewById(R.id.rcv_homework);
        final ItemHomeworkAdapter itemHomeworkAdapter = new ItemHomeworkAdapter(lsHomework);
        rcv_HomeWork.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcv_HomeWork.setAdapter(itemHomeworkAdapter);
        EditText editText = view.findViewById(R.id.edit_search);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                String key = s.toString();
                itemHomeworkAdapter.search(key);
            }
        });
//
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lsHomework = new ArrayList<>();
        lsHomework.add(new Homework("117224 - Phát triển ứng dụng cho thiết bị di động"));
        lsHomework.add(new Homework("IT4060 - Lập trình mạng - Mã lớp: 115644"));
        lsHomework.add(new Homework("Kỹ năng mềm(Mã lớp: 116876)"));
        lsHomework.add(new Homework("Thuật toán ứng dụng"));
        lsHomework.add(new Homework("Thuật toán ứng dụng(Mã lớp: 115641)"));
        lsHomework.add(new Homework("Lớp học 115642 - IT3120 - Phân tích thiết kế hệ thống"));
        lsHomework.add(new Homework("IT4010Q+IT4015 - Nhập môn An toàn thông tin"));

  //      final DetailHomeworkFragment detailHomeworkFragment = new DetailHomeworkFragment();


    }
}
