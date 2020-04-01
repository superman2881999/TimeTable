package android.app;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

public class KteamAdapter extends BaseAdapter {

    private Activity activity;
    private LinearLayout[] items;

    public KteamAdapter ( Activity activity,LinearLayout[] items){
        this.activity=activity;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inflater= activity.getLayoutInflater();
        view = inflater.inflate(R.layout.item_name,null);
        @SuppressLint("WrongViewCast") TextView tvName=(TextView) view.findViewById(R.id.tv_name);
        tvName.setText((CharSequence) items[i]);


        return null;
    }
}
