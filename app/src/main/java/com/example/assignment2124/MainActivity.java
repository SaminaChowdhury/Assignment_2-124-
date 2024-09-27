package com.example.assignment2124;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment2124.R;
import com.example.assignment2124.SecondActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText etName, etEmail;
    private TextInputEditText etPassword;  
    private TextInputLayout passwordLayout;
    private Button btnSubmit;
    private boolean isPasswordVisible = false; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       
        etName = findViewById(R.id.et_name);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);  
        passwordLayout = findViewById(R.id.passwordLayout);  
        btnSubmit = findViewById(R.id.btn_submit);

        
        setupPasswordVisibilityToggle();

       
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
            }
        });
    }

   
    private void setupPasswordVisibilityToggle() {
        passwordLayout.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPasswordVisible) {
                   
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                isPasswordVisible = !isPasswordVisible;
                etPassword.setSelection(etPassword.getText().length());  
            }
        });
    }

    private void validateForm() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (name.isEmpty() || !isValidName(name)) {
            etName.setError("Enter a valid name (alphabets only, at least 2 characters)");
            etName.requestFocus();
            return;
        }

       
        if (email.isEmpty() || !isValidEmail(email)) {
            etEmail.setError("Enter a valid email address");
            etEmail.requestFocus();
            return;
        }

        if (password.isEmpty() || !isValidPassword(password)) {
            etPassword.setError("Password must contain at least one digit, one lower, one upper case letter, and be 6+ characters long");
            etPassword.requestFocus();
            return;
        }

        
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

   
    private boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]{2,}$");
        return pattern.matcher(name).matches();
    }

   
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

   
    private boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$");
        return pattern.matcher(password).matches();
    }
}
