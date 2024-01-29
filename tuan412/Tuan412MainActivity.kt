package com.example.test.tuan412

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.test.R
import com.example.test.R.id.tuan412Btn

class Tuan412MainActivity : AppCompatActivity() {
    var btn:Button?= null
    var tvKQ:TextView?= null
    var context: Context = this
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan412_main)
        btn=findViewById(tuan412Btn)
        tvKQ=findViewById(R.id.tuan412TvKQ)
        val fn=VolleyKotLinFn()
        btn!!.setOnClickListener{
            fn.getJSONArrayObjects(context, tvKQ!!)
        }
    }
}