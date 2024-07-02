package com.example.attendease;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Create_QR extends AppCompatActivity {

    private TextView btnSelectTime,btnSelectTime2;
    private TextView txtSelectedEndTime, txtSelectedStartTime;
    private int selectedHour, selectedMinute;
    private EditText subjectName;
    private Button btnSubmit;
    private String time;
    private String startTime,endTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_qr);
        btnSubmit=findViewById(R.id.btnSubmit);
        subjectName=findViewById(R.id.subjectName);
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
        btnSubmit.setOnClickListener((v)->{
            Intent intent=new Intent(Create_QR.this, qrcode_activity.class);
            intent.putExtra("SubjectName",subjectName.getText().toString());
            intent.putExtra("StartTime",startTime);
            intent.putExtra("EndTime",endTime);
            startActivity(intent);

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
                    if(selectedHour>=12){
                        time=String.format("%02d:%02d", selectedHour, selectedMinute)+ "PM";
                    }
                    else {
                        time = String.format("%02d:%02d", selectedHour, selectedMinute )+"AM";
                    }
                    Toast.makeText(this, time, Toast.LENGTH_SHORT).show();
                    if(f){
                        btnSelectTime.setVisibility(View.GONE);
                        txtSelectedStartTime.setVisibility(View.VISIBLE);
                        startTime=time;
                        txtSelectedStartTime.setText(time);
                    }
                    else{
                        btnSelectTime2.setVisibility(View.GONE);
                        txtSelectedEndTime.setVisibility(View.VISIBLE);
                        endTime=time;
                        txtSelectedEndTime.setText(time);
                    }
                }, hour, minute, true);
        timePickerDialog.show();
    }




}