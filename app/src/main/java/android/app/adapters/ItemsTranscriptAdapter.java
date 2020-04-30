package android.app.adapters;

import android.app.R;
import android.app.models.Transcript;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsTranscriptAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Transcript> listTranscript;

    public ItemsTranscriptAdapter(List<Transcript> listTranscript) {
        this.listTranscript = listTranscript;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_transcript,parent,false);
        return new TranscriptViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TranscriptViewHolder viewHolder = (TranscriptViewHolder) holder;
        Transcript trans = listTranscript.get(position);
        viewHolder.tv_subject.setText(trans.getTv_subject());
        viewHolder.tv_point.setText(trans.getTv_point());
    }

    @Override
    public int getItemCount() {

        return listTranscript.size();
    }
    class TranscriptViewHolder extends RecyclerView.ViewHolder{

        TextView tv_subject;
        TextView tv_point;
        public TranscriptViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_subject = itemView.findViewById(R.id.tv_subject);
            tv_point = itemView.findViewById(R.id.tv_point);
        }
    }
}
