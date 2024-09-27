package com.example.assignment2124;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment2124.MainActivity;
import com.example.assignment2124.R;

public class SecondActivity extends AppCompatActivity {

    private CheckBox checkboxTerms;
    private RadioGroup radioGroupGender;
    private RatingBar ratingBar;
    private SeekBar seekBar;
    private Switch switchNotifications;
    private Button btnBack;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        
        checkboxTerms = findViewById(R.id.checkbox_terms);
        radioGroupGender = findViewById(R.id.radioGroup_gender);
        ratingBar = findViewById(R.id.ratingBar);
        seekBar = findViewById(R.id.seekBar);
        switchNotifications = findViewById(R.id.switch_notifications);
        btnBack = findViewById(R.id.btn_back);

        
        checkboxTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkboxTerms.isChecked()) {
                    Toast.makeText(SecondActivity.this, "Terms accepted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SecondActivity.this, "Please accept the terms", Toast.LENGTH_SHORT).show();
                }
            }
        });

        
        radioGroupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_male) {
                    Toast.makeText(SecondActivity.this, "Selected: Male", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radio_female) {
                    Toast.makeText(SecondActivity.this, "Selected: Female", Toast.LENGTH_SHORT).show();
                }
            }
        });

       
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(SecondActivity.this, "Rating: " + rating, Toast.LENGTH_SHORT).show();
            }
        });

        
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(SecondActivity.this, "Progress: " + progress, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
               
            }
        });

       
        switchNotifications.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(SecondActivity.this, "Notifications Enabled", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SecondActivity.this, "Notifications Disabled", Toast.LENGTH_SHORT).show();
            }
        });

       
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
