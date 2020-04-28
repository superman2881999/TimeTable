package android.app.activity;

import android.app.R;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONArray;

public class LoginActivity extends AppCompatActivity {
    private Button DangNhap;
    private EditText MS;
    private RadioGroup rg_choose;
    private RadioButton rb_teacher,rb_student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DangNhap= findViewById(R.id.DangNhap);
        MS =  findViewById(R.id.MS);
        rb_teacher = findViewById(R.id.rb_teacher);
        rb_student = findViewById(R.id.rb_student);
        rg_choose = findViewById(R.id.rg_choose);


        rb_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MS.setHint("Nhập MSGV");
            }
        });
        rb_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MS.setHint("Nhập MSSV");
            }
        });


        String mssv = MS.getText().toString().trim();
        DangNhap.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(LoginActivity.this,"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
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
