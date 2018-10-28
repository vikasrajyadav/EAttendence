package com.vikasraj.eattendence;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class facultyLoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_login);

        final EditText lRollno = (EditText) findViewById(R.id.rollno);
        final EditText lPassword = (EditText) findViewById(R.id.password);
        final Button bLogin = (Button) findViewById(R.id.login);
        final TextView tvRegisterLink = (TextView) findViewById(R.id.register1);


        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(facultyLoginActivity.this, facultyRegisterActivity.class);
                facultyLoginActivity.this.startActivity(registerIntent);
            }
        });


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = lRollno.getText().toString();
                final String password = lPassword.getText().toString();

                // Response received from the server
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                String name = jsonResponse.getString("name");
                                int age = jsonResponse.getInt("age");
                                int balance = jsonResponse.getInt("balance");

                                Intent intent = new Intent(facultyLoginActivity.this, FacultyActivity.class);
                                intent.putExtra("name", name);
                                intent.putExtra("age", age);
                                intent.putExtra("username", username);
                                intent.putExtra("balance",balance);
                                facultyLoginActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(facultyLoginActivity.this);
                                builder.setMessage("Username & Password is Incorrect")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                facultyLoginRequest loginRequest = new facultyLoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(facultyLoginActivity.this);
                queue.add(loginRequest);
            }
        });
    }
}