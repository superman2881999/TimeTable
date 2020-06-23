package android.app.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.R;
import android.app.adapters.ItemsAdapter;
import android.app.database.DBHelper;
import android.app.models.Day;
import android.app.models.Timetable2;
import android.app.networks.VolleySingleton;
import android.app.service.AlarmReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout textInputEmail, textInputPassword;
    private Button DangNhap;
    private CheckBox cbRememberPassword;

    String emailInput;
    String passwordInput;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        setEvent();

    }
    protected void init(){
        DangNhap= findViewById(R.id.DangNhap);
        textInputEmail =  findViewById(R.id.edt_gmail);
        textInputPassword = findViewById(R.id.edt_password);
        cbRememberPassword = findViewById(R.id.checkbox);
    }
    protected void setEvent(){
        DangNhap.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                validateInput();
            }
        });

        sharedPreferences=getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        editor=sharedPreferences.edit();

        String mail=sharedPreferences.getString("email","");
        String passwords=sharedPreferences.getString("passowrd","");

        textInputEmail.getEditText().setText(mail);
        textInputPassword.getEditText().setText(passwords);


    }

    // check email
    private boolean validateEmail(){

        emailInput = textInputEmail.getEditText().getText().toString().trim();
        if(TextUtils.isEmpty(emailInput)){
            textInputEmail.setError("Vui lòng nhập thông tin email.");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            textInputEmail.setError("Email sai cú pháp.");
            return false;
        }else{
            textInputEmail.setError(null);
            return true;
        }
    }
    //check password
    private boolean validatePassword(){
//        String hashed = BCrypt.hashpw(passwordInput, BCrypt.gensalt());

        passwordInput = textInputPassword.getEditText().getText().toString().trim();
        if(TextUtils.isEmpty(passwordInput)){
            textInputPassword.setError("Vui lòng nhập thông tin password.");
            return false;
        } else{
            textInputPassword.setError(null);
            return true;
        }
    }

    private void confirmInput(){
        if(!emailInput.equals("dung.la173054@sis.hust.edu.vn")) {
            textInputEmail.setError("Tài khoản email này không tồn tại.");
            return;
        }
        else if(!passwordInput.equals("123456")) {
            textInputPassword.setError("Sai thông tin password.");
            return;
        }
        if(cbRememberPassword.isChecked()){
            editor.putString("email",textInputEmail.getEditText().getText().toString());
            editor.putString("passowrd",textInputPassword.getEditText().getText().toString());
            editor.commit();
        }else{
            editor.putString("email","");
            editor.putString("passowrd","");
            editor.commit();
        }
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }

    //check input
    private void validateInput(){
        if(!validateEmail() || !validatePassword()){
            return;
        }
        confirmInput();

    }



}
