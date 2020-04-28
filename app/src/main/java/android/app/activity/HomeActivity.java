package android.app.activity;

import android.app.R;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import android.app.fragment.AlarmFragment;
import android.app.fragment.HomeworkFragment;
import android.app.fragment.NotificationFragment;
import android.app.fragment.AccountFragment;
import android.app.fragment.TranscriptFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        InitView();
    }

    private void InitView(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Bottom Navigation
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navLisener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AlarmFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navLisener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch(menuItem.getItemId()){
                        case R.id.nav_schedule:
                            selectedFragment = new AlarmFragment();
                            toolbar.setTitle(R.string.nav_alarm);
                            break;
                        case R.id.nav_transcript:
                            selectedFragment = new TranscriptFragment();
                            toolbar.setTitle(R.string.nav_transcript);
                            break;
                        case R.id.nav_notification:
                            selectedFragment = new NotificationFragment();
                            toolbar.setTitle(R.string.nav_notification);
                            break;
                        case R.id.nav_homework:
                            selectedFragment = new HomeworkFragment();
                            toolbar.setTitle(R.string.nav_homework);
                            break;
                        case R.id.nav_account:
                            selectedFragment = new AccountFragment();
                            toolbar.setTitle(R.string.nav_account);
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return  true;
                }
            };
}
