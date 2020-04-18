package android.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.app.R;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.Connection;
import android.connection.connection;
import android.connection.DAO;

import java.sql.SQLException;

public class DangNhap extends AppCompatActivity {
    private Button DangNhap;
    private EditText MSSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        DangNhap= (Button) findViewById(R.id.DangNhap);
        MSSV = (EditText) findViewById(R.id.MSSV);
        DangNhap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                try {
//                    if(MSSV.getText().toString() == dao.ht()){
                        Toast.makeText(DangNhap.this,"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DangNhap.this, MainActivity.class);
                            startActivity(intent);
//                    }
//                    else {
//                        Toast.makeText(DangNhap.this,"Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
//                    }
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
