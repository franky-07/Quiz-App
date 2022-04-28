package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.btnStart.setOnClickListener {
            if(bind.etName.text.toString().isEmpty())
                Toast.makeText(this,"Enter Your Name First",Toast.LENGTH_SHORT).show()
            else{
                val intent = Intent(this,QuestionsList::class.java)
                intent.putExtra(Constants.user_name, bind.etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}