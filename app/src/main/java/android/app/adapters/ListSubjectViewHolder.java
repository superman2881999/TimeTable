package android.app.adapters;

import android.app.R;
import android.app.models.Day;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class ListSubjectViewHolder extends GroupViewHolder {

    private TextView tvThu;
    private ImageView arrow;

    public ListSubjectViewHolder(View itemView) {
        super(itemView);
        tvThu = itemView.findViewById(R.id.tv_thu);
        arrow = itemView.findViewById(R.id.arrow);
    }
    public void bind(Day day) {
        arrow.setVisibility(View.VISIBLE);
        tvThu.setText(day.getTitle());
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        RotateAnimation rotate = new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate = new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}
