package com.example.attendease;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class Create_QR extends AppCompatActivity {

    private Button btnSelectTime,btnSelectTime2;
    private TextView txtSelectedEndTime, txtSelectedStartTime;
    private int selectedHour, selectedMinute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_qr);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSelectTime=findViewById(R.id.btnSelectTime);
        txtSelectedStartTime=findViewById(R.id.txtSelectedStartTime);
        txtSelectedEndTime=findViewById(R.id.txtSelectedEndTime);
        txtSelectedStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker(true);
            }
        });
        txtSelectedEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker(false);
            }
        });
        btnSelectTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker(true);
            }

        });
        btnSelectTime2=findViewById(R.id.btnSelectTime2);
        btnSelectTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker(false);
            }

        });

    }


    private void showTimePicker(boolean f) {
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minute1) -> {
                    selectedHour = hourOfDay;
                    selectedMinute = minute1;
                    String time = String.format("%02d:%02d", selectedHour, selectedMinute);
                    Toast.makeText(this, time, Toast.LENGTH_SHORT).show();
                    if(f){
                        btnSelectTime.setVisibility(View.GONE);
                        txtSelectedStartTime.setVisibility(View.VISIBLE);
                        txtSelectedStartTime.setText(time);
                    }
                    else{
                        btnSelectTime2.setVisibility(View.GONE);
                        txtSelectedEndTime.setVisibility(View.VISIBLE);
                        txtSelectedEndTime.setText(time);
                    }
                }, hour, minute, true);
        timePickerDialog.show();
    }




}