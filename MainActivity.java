package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText etLoginUsername;
    private EditText etLoginPassword;
    private Button loginButton;
    private Button  register_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLoginUsername = findViewById(R.id.et_id);
        etLoginPassword = findViewById(R.id.editTextTextPassword2);
        loginButton = findViewById(R.id.btn_login);
        register_btn = findViewById(R.id.btn_register);

        loginButton.setOnClickListener(view -> {

            // 사용자가 입력한 아이디와 패스워드 가져오기
            String enteredUsername = etLoginUsername.getText().toString();
            String enteredPassword = etLoginPassword.getText().toString();



            // 저장된 회원 정보 가져오기
            SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
            String savedUsername = sharedPreferences.getString("username", "");
            String savedPassword = sharedPreferences.getString("password", "");


            // 아이디와 패스워드 비교
            if (enteredUsername.equals(savedUsername) && enteredPassword.equals(savedPassword)) {
                // 로그인 성공 시 다음 화면으로 이동 (여기서는 MainActivity로 이동)

            } else {
                // 로그인 실패 처리 (예: 에러 메시지 표시)
                Toast.makeText(MainActivity.this, "아이디 또는 비밀번호 오류입니다.", Toast.LENGTH_SHORT).show();
            }
        });
        register_btn.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), Register.class);
            startActivity(intent);
        });


    }
}