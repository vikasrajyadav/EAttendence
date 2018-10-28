package com.vikasraj.eattendence;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class facultyRegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "http://vikasrajyadav.com/vry/Register2.php";
    private Map<String, String> params;

    public facultyRegisterRequest(String FisrtName, String LastName, String Rollno, String email, int phone, String Department, String year, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("firstname", FisrtName);
        params.put("lastname", LastName);
        params.put("rollno", Rollno);
        params.put("email", email);
        params.put("phone", phone + "");
        params.put("department", Department);
        params.put("year", year);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}