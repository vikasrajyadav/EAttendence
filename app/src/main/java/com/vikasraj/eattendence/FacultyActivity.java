package com.vikasraj.eattendence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


public class FacultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        final Button bSameSchedule = (Button) findViewById(R.id.SameSchedule);
        final Button bChangeInSchedule = (Button) findViewById(R.id.Changeinschedule);


        bSameSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(FacultyActivity.this, SameScheduleAttend.class);
//                registerIntent.putExtra("username", username1);
//                registerIntent.putExtra("balance",balance);
                FacultyActivity.this.startActivity(registerIntent);
            }
        });

        bChangeInSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(FacultyActivity.this, ChangeInScheduleAttend.class);
//                registerIntent.putExtra("username", username1);
//                registerIntent.putExtra("balance",balance);
                FacultyActivity.this.startActivity(registerIntent);
            }
        });


    }
}
