package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.databinding.ActivityQuestionsListBinding
import com.example.quizapp.databinding.ActivityScoreBoardBinding

class ScoreBoardActivity : AppCompatActivity() {
    private lateinit var  bind :ActivityScoreBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityScoreBoardBinding.inflate(layoutInflater)
        setContentView(bind.root)
        bind.userName.text = intent.getStringExtra(Constants.user_name)
        bind.scoreBoard.text = "Your Score is ${ intent.getStringExtra(Constants.correct_answer)}/${intent.getStringExtra(Constants.total_answer)}"
        bind.buttonFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}