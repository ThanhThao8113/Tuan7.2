package com.example.test.tuan412

import android.content.Context
import android.widget.TextView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class VolleyKotLinFn {
    var strJSON=""
    fun getJSONArrayObjects(context: Context, textView: TextView){
        //1 tao request
        val queue=Volley.newRequestQueue(context);
        //2 url
        val url ="http://192.168.1.3/ajson/a.json";
        // 3 goi request
        val request=JsonArrayRequest(url,
            {
                response ->
                for (i in 0 until response.length()){
                    val person=response.getJSONObject(i)
                    val id=person.getString("id")
                    val name=person.getString("name")
                    val email = person.getString("email")
                    //dua tat ca vao textView
                    strJSON += "id: $id\n"
                    strJSON += "name: $name\n"
                    strJSON += "email: $email\n"
                }
            },
            {
                error ->  textView.text= error.message
            })
        //4 thuc thi request
        queue.add(request);
    }
}