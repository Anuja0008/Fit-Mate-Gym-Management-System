package com.example.fitmate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitmate.activities.MainActivity;
import com.example.fitmate.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText edtName, edtEmail, edtPassword, edtPhone   ;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtPhone = findViewById(R.id.edtPhone);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> validateAndRegister());
    }

    private void validateAndRegister() {
        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();


        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()
                || TextUtils.isEmpty(password) || password.length() < 6
                || TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show();
            return;
        }


        Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show();

        // Navigate to MainActivity (or any other activity)
        Intent intent = new Intent(RegisterActivity.this, RegisterUserActivity.class);
        startActivity(intent);
        finish();
    }
}
