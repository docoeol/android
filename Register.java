package com.example.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPassword;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.et_pass);
        etPassword = findViewById(R.id.et_name);
        etConfirmPassword = findViewById(R.id.et_name2);
        registerButton = findViewById(R.id.register_btn);

        registerButton.setOnClickListener(view -> {
            // 사용자가 입력한 아이디와 패스워드 가져오기
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();
            String confirmPassword = etConfirmPassword.getText().toString();

            // 패스워드와 패스워드 확인이 일치하는지 확인
            if (!password.equals(confirmPassword)) {
                // 패스워드가 일치하지 않으면 오류 메시지 표시
                Toast.makeText(Register.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
            } else {
                // 회원 정보를 저장 (예: SharedPreferences 사용)
                SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", username);
                editor.putString("password", password);
                editor.apply();

                // 회원가입 후 로그인 화면으로 이동
                Intent intent = new Intent(Register.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}