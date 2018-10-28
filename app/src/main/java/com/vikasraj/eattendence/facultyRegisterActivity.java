package com.vikasraj.eattendence;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class facultyRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_register);

        final EditText etFirstName = (EditText) findViewById(R.id.FirstName);
        final EditText etLastName = (EditText) findViewById(R.id.LastName);
        final EditText etRollno = (EditText) findViewById(R.id.rollno);
        final EditText etEmail = (EditText) findViewById(R.id.email);
        final EditText etPhone = (EditText) findViewById(R.id.phone);
        final Button bRegister = (Button) findViewById(R.id.Rregister);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String FirstName = etFirstName.getText().toString();
                final String LastName = etLastName.getText().toString();
                final String email = etEmail.getText().toString();
                final int phone = Integer.parseInt(etPhone.getText().toString());
                final String rollno = etRollno.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(facultyRegisterActivity.this, LoginActivity.class);
                                facultyRegisterActivity.this.startActivity(intent);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(facultyRegisterActivity.this);
                                builder.setMessage("Register Failed \n'" + rollno + "' username is not available")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                facultyRegisterRequest registerRequest = new facultyRegisterRequest(FirstName, LastName, rollno, email, phone,"Computer", "1st", responseListener);
                RequestQueue queue = Volley.newRequestQueue(facultyRegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}

