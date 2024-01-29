package com.example.test.tuan41;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tuan41VolleyFn {
    String strnJSON="";
    public void getJsonArrayOfObject(Context context, TextView textView){
        //1 Tao request
        RequestQueue queue= Volley.newRequestQueue(context);
        //2 Url
        String url="http://192.168.1.3/ajson/a.json";
        //3 goi request
        //JsonArrayRequest(url, thanh cong, that bai)
        JsonArrayRequest request=new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //chuyen mang sang cac doi tuong
                        for(int i=0;i<response.length();i++){
                            try {
                                JSONObject person=response.getJSONObject(i);//lay tung doi tuong
                                String id=person.getString("id");
                                String name=person.getString("name");
                                String email=person.getString("email");
                                //
                                strnJSON += "Id: "+ id + "\n";
                                strnJSON += "Name: "+ name + "\n";
                                strnJSON += "Email: "+ email + "\n";
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            textView.setText(strnJSON);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        //4 thuc thi request
        queue.add(request);
    }
}
