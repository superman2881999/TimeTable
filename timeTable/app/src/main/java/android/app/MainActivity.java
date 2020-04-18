package android.app;

import android.annotation.SuppressLint;
import android.app.adapters.KteamAdapter;
import android.app.models.ItemModel;
import android.os.Bundle;

import android.app.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

    List<ItemModel> list;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
       Faker faker = new Faker();
          for(int i=0 ; i<=7;i++){
              list.add(new ItemModel(faker.date.toString(),faker.lorem.sentence(),faker.lorem.sentence(),faker.time.toString(),faker.time.toString()));
          }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new KteamAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
