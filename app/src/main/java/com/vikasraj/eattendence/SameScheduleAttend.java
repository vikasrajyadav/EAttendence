package com.vikasraj.eattendence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SameScheduleAttend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_schedule_attend);

        Button StartAttend = (Button) findViewById(R.id.StartAttendence);

        StartAttend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(SameScheduleAttend.this, AttendenceStartPortal.class);
//                registerIntent.putExtra("username", username1);
//                registerIntent.putExtra("balance",balance);
                SameScheduleAttend.this.startActivity(registerIntent);
            }
        });

    }
}
