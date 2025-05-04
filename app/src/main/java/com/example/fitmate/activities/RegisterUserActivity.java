package com.example.fitmate.activities;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fitmate.R;

public class RegisterUserActivity extends AppCompatActivity {

    private EditText edtAge, edtHeight, edtWeight;
    private RadioGroup genderGroup;
    private CheckBox cbCancer, cbHeart, cbDiabetes, cbCholesterol;
    private Button btnSubmitUserData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        edtAge = findViewById(R.id.edtAge);
        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        genderGroup = findViewById(R.id.genderGroup);

        cbCancer = findViewById(R.id.cbCancer);
        cbHeart = findViewById(R.id.cbHeart);
        cbDiabetes = findViewById(R.id.cbDiabetes);
        cbCholesterol = findViewById(R.id.cbCholesterol);

        btnSubmitUserData = findViewById(R.id.btnSubmitUserData);

        btnSubmitUserData.setOnClickListener(v -> validateUserData());
    }

    private void validateUserData() {
        String age = edtAge.getText().toString().trim();
        String height = edtHeight.getText().toString().trim();
        String weight = edtWeight.getText().toString().trim();

        int selectedGenderId = genderGroup.getCheckedRadioButtonId();

        if (TextUtils.isEmpty(age) || TextUtils.isEmpty(height) || TextUtils.isEmpty(weight) || selectedGenderId == -1) {
            Toast.makeText(this, "Please complete all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedGenderButton = findViewById(selectedGenderId);
        String gender = selectedGenderButton.getText().toString();

        StringBuilder healthConditions = new StringBuilder();
        if (cbCancer.isChecked()) healthConditions.append("Cancer, ");
        if (cbHeart.isChecked()) healthConditions.append("Heart Patient, ");
        if (cbDiabetes.isChecked()) healthConditions.append("Diabetes, ");
        if (cbCholesterol.isChecked()) healthConditions.append("Cholesterol, ");

        if (healthConditions.length() > 0) {
            healthConditions.setLength(healthConditions.length() - 2); // remove last comma
        } else {
            healthConditions.append("None");
        }

        String result = "Age: " + age + "\nHeight: " + height + " cm\nWeight: " + weight + " kg\nGender: " + gender + "\nHealth Issues: " + healthConditions;

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }
}
