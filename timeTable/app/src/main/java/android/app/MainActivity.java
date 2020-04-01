package android.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout[] items = new LinearLayout[6];
        listView=(ListView) findViewById(R.id.list_view);
        KteamAdapter adapter =new KteamAdapter(this, items);
        listView.setAdapter(adapter);
    }
}
