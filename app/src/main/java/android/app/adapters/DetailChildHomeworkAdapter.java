package android.app.adapters;

import android.app.R;
import android.app.models.DetailChildHomeworkModel;
import android.app.models.Timetable2;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class DetailChildHomeworkAdapter extends ChildViewHolder {
    private TextView tvNameHomework;

    public DetailChildHomeworkAdapter(View itemView) {
        super(itemView);
        tvNameHomework = itemView.findViewById(R.id.tv_name_homework);

    }

    public void bind(DetailChildHomeworkModel detailChild) {

        tvNameHomework.setText(detailChild.name_homework);

    }

}
