package com.example.miniact2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK){
            val editTextMsg : EditText = findViewById(R.id.byeMsg)
            editTextMsg.text.clear()
            val editTextRep : EditText = findViewById(R.id.numRep)
            editTextRep.text.clear()
            val intent : Intent? = result.data
            val textView : TextView = findViewById(R.id.textView)
            textView.text = intent?.getStringExtra("finalText").toString()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button : Button = findViewById(R.id.button)
        val editTextMsg : EditText = findViewById(R.id.byeMsg)
        editTextMsg.hint = "Bye message"

        val editTextRep : EditText = findViewById(R.id.numRep)

        editTextRep.hint = "Num of sequences"
        var intent : Intent = Intent(this,RepActivity::class.java)
        button.setOnClickListener{
            var msg = editTextMsg.text.toString()
            var rep = editTextRep.text.toString()

            if (rep.isEmpty() || msg.isEmpty() || rep=="0"){
                msg = "Default BYE"
                rep = "1"
            }
            intent.putExtra("msg",msg)
            intent.putExtra("rep",rep.toInt())
            startForResult.launch(intent)
        }

    }

}