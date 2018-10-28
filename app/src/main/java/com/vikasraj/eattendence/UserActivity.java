package com.vikasraj.eattendence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final String username1 = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);
        final int balance = intent.getIntExtra("balance",-1);

        TextView Firstname = (TextView) findViewById(R.id.userFirstName);
        TextView rollno = (TextView) findViewById(R.id.userRollno);
        TextView tvBook = (TextView) findViewById(R.id.markAttendenceB);

        // Display user details
        String message = name;
        Firstname.setText(message);
        rollno.setText(username1);
        tvBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(UserActivity.this, StudentScanningCode.class);
                registerIntent.putExtra("username", username1);
                registerIntent.putExtra("balance",balance);
                UserActivity.this.startActivity(registerIntent);
            }
        });


    }

}