package android.app.adapters;

import android.app.R;
import android.app.models.DetailChildHomeworkModel;
import android.app.models.DetailGroupHomeworkModel;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ItemDetailHomeworkAdapter extends ExpandableRecyclerViewAdapter<DetailGroupHomeworkAdapter, DetailChildHomeworkAdapter> {

    List<? extends ExpandableGroup> grupo;
    private static AdapterView.OnItemClickListener listener;
    Context mContext;
    LayoutInflater mInflater;

    public ItemDetailHomeworkAdapter(List<? extends ExpandableGroup> groups, Context context) {
        super(groups);
        grupo = groups;
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }


    @Override
    public DetailGroupHomeworkAdapter onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group_homework, parent, false);
        return new DetailGroupHomeworkAdapter(v);

    }

    @Override
    public DetailChildHomeworkAdapter onCreateChildViewHolder(final ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child_homework, parent, false);
        //final SubjectViewHolder mViewHolder = new SubjectViewHolder(v);
        //        v.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View v) {
        //        displayAlertDialog();
        //        }
        //        });
        return new DetailChildHomeworkAdapter(v);
    }

    @Override
    public void onBindChildViewHolder(DetailChildHomeworkAdapter holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final DetailChildHomeworkModel detailChildHomeworkModel = (DetailChildHomeworkModel) group.getItems().get(childIndex);
        holder.bind(detailChildHomeworkModel);

    }

    @Override
    public void onBindGroupViewHolder(DetailGroupHomeworkAdapter holder, int flatPosition, ExpandableGroup group) {
        final DetailGroupHomeworkModel detailGroupHomeworkModel = (DetailGroupHomeworkModel) group;
        holder.bind(detailGroupHomeworkModel);
    }

    public void expandAllGroups() {

        for (int i = 0; i < grupo.size(); i++) {
            if (!isGroupExpanded(grupo.get(i))) {
                onGroupClick(expandableList.getFlattenedGroupIndex(i));
            }
        }
    }
}
