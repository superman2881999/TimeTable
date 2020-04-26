package android.app.adapters;

import android.app.R;
import android.app.models.Timetable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class KteamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Timetable> items;

    public KteamAdapter(List<Timetable> items) {

        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Timetable itemModel = items.get(position);
        ViewHolder viewHolder =(ViewHolder) holder;
        viewHolder.tvDay.setText(itemModel.getTvDay());
        viewHolder.tvSubject.setText(itemModel.getTvSubject());
        viewHolder.tvRoom.setText(itemModel.getTvRoom());
        viewHolder.timeStart.setText(itemModel.getTimeStart());
        viewHolder.timeEnd.setText(itemModel.getTimeEnd());
    }

    @Override
    public int getItemCount()
    {

        return items.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvDay;
        TextView tvSubject;
        TextView tvRoom;
        TextView timeStart;
        TextView timeEnd;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tv_day);
            tvSubject = itemView.findViewById(R.id.tv_subject);
            tvRoom = itemView.findViewById(R.id.tv_room);
            timeStart = itemView.findViewById(R.id.tv_timeStart);
            timeEnd = itemView.findViewById(R.id.tv_timeEnd);
        }
    }
}
