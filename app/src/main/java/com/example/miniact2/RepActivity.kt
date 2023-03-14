package com.example.miniact2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class RepActivity  : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rep_activity)
        val textView : TextView = findViewById(R.id.textViewAct2)
        val msg : String = intent.getStringExtra("msg").toString()
        var numRep = intent.getIntExtra("rep",-1)
        var finalText  :String = ""
        while(numRep>0){
            finalText +=msg
            numRep--
        }
        textView.text = finalText
        val goBackButton : Button = findViewById(R.id.buttonAct2)
        goBackButton.setOnClickListener{
            var retIntent : Intent = Intent()
            retIntent.putExtra("finalText",finalText)
            setResult(RESULT_OK,retIntent)
            finish()

        }


    }
}