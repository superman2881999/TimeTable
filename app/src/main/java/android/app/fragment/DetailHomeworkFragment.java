package android.app.fragment;

import android.app.R;
import android.app.adapters.ItemDetailHomeworkAdapter;
import android.app.adapters.ItemsAdapter;
import android.app.models.Day;
import android.app.models.DetailChildHomeworkModel;
import android.app.models.DetailGroupHomeworkModel;
import android.app.models.Timetable2;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;


public class DetailHomeworkFragment extends Fragment {

    private RecyclerView rcv_detail_homework;
    private ArrayList<DetailChildHomeworkModel> lsDetailHomework;
    private ArrayList<DetailGroupHomeworkModel> lsStatus;

    View view;
    ItemDetailHomeworkAdapter itemDetailHomeworkAdapter;

    public DetailHomeworkFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detail_homework, container, false);

        rcv_detail_homework = view.findViewById(R.id.rcv_detail_homework);
        rcv_detail_homework.setLayoutManager(new LinearLayoutManager(getActivity()));
        lsStatus = new ArrayList<>();
        lsDetailHomework = new ArrayList<>();

        lsDetailHomework.add(new DetailChildHomeworkModel("Bài tập về nhà ngày 19/03/2020"));
        lsDetailHomework.add(new DetailChildHomeworkModel("Bài tập về nhà ngày 26/03/2020"));
        lsDetailHomework.add(new DetailChildHomeworkModel("Bài tập về nhà ngày 09/04/2020"));
        lsDetailHomework.add(new DetailChildHomeworkModel("Bài tập về nhà tuần 7( ngày 16/04/2020"));
        lsDetailHomework.add(new DetailChildHomeworkModel("Bài tập về nhà ngày 23/04/2020"));
        lsDetailHomework.add(new DetailChildHomeworkModel("Bài tập về nhà ngày 30/04/2020"));

        DetailGroupHomeworkModel detailGroupHomeworkModel = new DetailGroupHomeworkModel("Completed",lsDetailHomework);
        lsStatus.add(detailGroupHomeworkModel);

        lsDetailHomework = new ArrayList<>();

        lsDetailHomework.add(new DetailChildHomeworkModel("Không có sự kiện nào"));
        DetailGroupHomeworkModel detailGroupHomeworkModel2 = new DetailGroupHomeworkModel("Assigned",lsDetailHomework);
        lsStatus.add(detailGroupHomeworkModel2);

        itemDetailHomeworkAdapter = new ItemDetailHomeworkAdapter(lsStatus,getContext());

        rcv_detail_homework.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                rcv_detail_homework.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                itemDetailHomeworkAdapter.expandAllGroups();
            }
        });

        rcv_detail_homework.setAdapter(new ScaleInAnimationAdapter(itemDetailHomeworkAdapter));

        return view;
    }
}