package android.app.adapters;

import android.app.R;
import android.app.models.Day;
import android.app.models.DetailGroupHomeworkModel;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class DetailGroupHomeworkAdapter extends GroupViewHolder {

    private TextView tvStatus;
    private ImageView imvArrow;

    public DetailGroupHomeworkAdapter(View itemView) {
        super(itemView);
        tvStatus = itemView.findViewById(R.id.tv_status);
        imvArrow = itemView.findViewById(R.id.imv_arrow);
    }
    public void bind(DetailGroupHomeworkModel detailGroupHomeworkModel) {
        imvArrow.setVisibility(View.VISIBLE);
        tvStatus.setText(detailGroupHomeworkModel.getTitle());
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
        imvArrow.setAnimation(rotate);
    }

    private void animateCollapse() {
        RotateAnimation rotate = new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        imvArrow.setAnimation(rotate);
    }
}