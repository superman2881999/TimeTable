package android.app.adapters;

import android.app.R;
import android.app.models.Homework;
import android.app.models.Transcript;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
public class ItemHomeworkAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Homework> allListHomework;
    List<Homework> displayHomework;
    public ItemHomeworkAdapter(List<Homework> listHomework) {
        this.allListHomework = listHomework;
        displayHomework = new ArrayList<>();
        displayHomework.addAll(listHomework);
    }
    public void showAll() {
        displayHomework.clear();
        displayHomework.addAll(allListHomework);
        notifyDataSetChanged();
    }
    public void search(String keywork) {
        displayHomework.clear();
        for (Homework items : allListHomework) {
            if (items.getClassname().contains(keywork))
                displayHomework.add(items);
        }
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_homework, parent,false);
        return new HomeworkViewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemHomeworkAdapter.HomeworkViewholder viewHolder = (ItemHomeworkAdapter.HomeworkViewholder) holder;
        Homework homework = displayHomework.get(position);
        viewHolder.firstname.setText(homework.getClassname().substring(0,1));
        viewHolder.classname.setText(homework.getClassname());
    }
    @Override
    public int getItemCount() {
        return displayHomework.size();
    }
    class HomeworkViewholder extends RecyclerView.ViewHolder {
        TextView classname;
        TextView firstname;
        public HomeworkViewholder(@NonNull View itemView) {
            super(itemView);
            classname = itemView.findViewById(R.id.tv_classname);
            firstname = itemView.findViewById(R.id.tv_firstname);
        }
    }
}

