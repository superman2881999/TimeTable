package android.app.adapters;

import android.app.R;
import android.app.models.transcript;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemTranscriptAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<transcript> list;
    Context context;
    private PieChart mChart;

    public ItemTranscriptAdapter(List<transcript> list, Context context, PieChart mChart) {
        this.list = list;
        this.context = context;
        this.mChart = mChart;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transcript, parent,false);
        return new TranscriptViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final ItemTranscriptAdapter.TranscriptViewholder viewHolder = (ItemTranscriptAdapter.TranscriptViewholder) holder;
        final transcript trans = list.get(position);
        viewHolder.ten_mon_hoc.setText(trans.getTen_mon_hoc());
        mChart.setRotationEnabled(true);
        mChart.setDescription(new Description());
        mChart.setHoleRadius(35f);
        mChart.setTransparentCircleAlpha(0);
        mChart.setCenterText("Điểm đánh giá");
        mChart.setCenterTextSize(10);
        mChart.setDrawEntryLabels(true);

        addDataSet(mChart,10,6,7);
        final int[] check = {1,0,0,0,0,0};
        changeTypeFace(check,viewHolder.ten_mon_hoc);
        viewHolder.ten_mon_hoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(trans.getTen_mon_hoc().equals("Thuật toán ứng dụng")){
                    addDataSet(mChart,10,6,7);
                    reset(check);
                    check[0] =1;
                    viewHolder.ten_mon_hoc.setTypeface(null,Typeface.BOLD);
                    changeTypeFace(check,viewHolder.ten_mon_hoc);

                }
                else if(trans.getTen_mon_hoc().equals("Kỹ năng mềm")){
                    addDataSet(mChart,10,6,8);
                    reset(check);
                    check[1]=1;
                    viewHolder.ten_mon_hoc.setTypeface(null,Typeface.BOLD);
                    changeTypeFace(check,viewHolder.ten_mon_hoc);
                }
                else if(trans.getTen_mon_hoc().equals("Phân tích thiết kế hệ thống")){
                    addDataSet(mChart,10,6,9.5f);
                    reset(check);
                    check[2]=1;
                    viewHolder.ten_mon_hoc.setTypeface(null,Typeface.BOLD);
                    changeTypeFace(check,viewHolder.ten_mon_hoc);
                }
                else if(trans.getTen_mon_hoc().equals("Lập trình mạng")){
                    addDataSet(mChart,10,6,7);
                    reset(check);
                    check[3]=1;
                    viewHolder.ten_mon_hoc.setTypeface(null,Typeface.BOLD);
                    changeTypeFace(check,viewHolder.ten_mon_hoc);
                }
                else if(trans.getTen_mon_hoc().equals("Phát triển ứng dụng cho thiết bị di động")){
                    addDataSet(mChart,10,6,9);
                    reset(check);
                    check[4]=1;
                    viewHolder.ten_mon_hoc.setTypeface(null,Typeface.BOLD);
                    changeTypeFace(check,viewHolder.ten_mon_hoc);
                }
                else if(trans.getTen_mon_hoc().equals("An toàn thông tin")){
                    addDataSet(mChart,10,6,7.5f);
                    reset(check);
                    check[5]=1;
                    viewHolder.ten_mon_hoc.setTypeface(null,Typeface.BOLD);
                    changeTypeFace(check,viewHolder.ten_mon_hoc);
                }


            }
        });

    }
    public void reset(int check[]){
        for(int i =0;i<check.length;i++){
            check[i]=0;
        }
    }
    public void changeTypeFace(int check[], TextView textView){
        for(int i =0;i<check.length;i++){
            if(check[i]==1){
                textView.setTypeface(null,Typeface.BOLD);
            }
            else{
                textView.setTypeface(null,Typeface.NORMAL);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TranscriptViewholder extends RecyclerView.ViewHolder {
        TextView ten_mon_hoc;
        public TranscriptViewholder(@NonNull View itemView) {
            super(itemView);
            ten_mon_hoc = itemView.findViewById(R.id.tv);

        }
    }

    private static void addDataSet(PieChart pieChart, float a, float b, float c) {
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();
        float[] yData = { a, b, c };
        String[] xData = { "Điểm tham dự lớp", "Điểm đánh giá thường xuyên", "Điểm đánh giá định kì" };

        for (int i = 0; i < yData.length;i++){
            yEntrys.add(new PieEntry(yData[i],i));
        }
        for (int i = 0; i < xData.length;i++){
            xEntrys.add(xData[i]);
        }

        PieDataSet pieDataSet=new PieDataSet(yEntrys,"Employee Sales");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        ArrayList<Integer> colors=new ArrayList<>();
        colors.add(Color.GRAY);
        colors.add(Color.BLUE);
        colors.add(Color.RED);

        pieDataSet.setColors(colors);

        Legend legend=pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setExtra(colors, Arrays.asList(xData));
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_RIGHT);

        PieData pieData=new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

}
