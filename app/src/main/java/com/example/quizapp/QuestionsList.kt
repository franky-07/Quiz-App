package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.TextureView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityQuestionsListBinding
import org.w3c.dom.Text

class QuestionsList : AppCompatActivity() ,View.OnClickListener {
    private var questionList:ArrayList<Questions>?=null
    private var mCurrentPosition:Int = 1
    private var mSelectedOptionNum:Int = 0
    private var mUserName:String?=null
    private var mCorrectAns:Int = 0

    private lateinit var bind: ActivityQuestionsListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityQuestionsListBinding.inflate(layoutInflater)
        setContentView(bind.root)
        mUserName = intent.getStringExtra(Constants.user_name)
        questionList=Constants.getQuestion()
        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionBg()
        val question:Questions = questionList!![mCurrentPosition-1]
        bind.progressBar.progress=mCurrentPosition
        bind.tvProgress.text ="${mCurrentPosition.toString()}/${bind.progressBar.max.toString()}"
        bind.tvQuestion.text = question.question
        bind.tvOptionOne.text = question.optionOne
        bind.tvOptionTwo.text = question.optionTwo
        bind.tvOptionThree.text = question.optionThree
        bind.tvOptionFour.text = question.optionFour
        bind.ivFlag.setImageResource(question.image)
        bind.tvOptionOne.setOnClickListener(this)
        bind.tvOptionTwo.setOnClickListener(this)
        bind.tvOptionThree.setOnClickListener(this)
        bind.tvOptionFour.setOnClickListener(this)
        bind.btnSubmit.setOnClickListener(this)

        if(mCurrentPosition!=questionList?.size)
            bind.btnSubmit.text = "SUBMIT"
        else
            bind.btnSubmit.text = "FINISH"
    }
    private fun defaultOptionBg(){
        val options = ArrayList<TextView>()
        bind.tvOptionOne.let {
            options.add(0,it)
        }
        bind.tvOptionTwo.let {
            options.add(1,it)
        }
        bind.tvOptionThree.let {
            options.add(2,it)
        }
        bind.tvOptionFour.let {
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#CCC7C7"))
            option.typeface = Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this,
                R.drawable.option_drawable
            )
        }
    }
    private fun selectedOptionBg(tv: TextView,selectedNum:Int){
        defaultOptionBg()
        mSelectedOptionNum = selectedNum
        tv.setTextColor(Color.parseColor("#363A34"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_drawable
        )
    }
    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tvOptionOne->{
                selectedOptionBg(bind.tvOptionOne,1)
            }
            R.id.tvOptionTwo->{
                selectedOptionBg(bind.tvOptionTwo,2)
            }
            R.id.tvOptionThree->{
                selectedOptionBg(bind.tvOptionThree,3)
            }
            R.id.tvOptionFour->{
                selectedOptionBg(bind.tvOptionFour,4)
            }
            R.id.btnSubmit->{
                if(mSelectedOptionNum==0){
                   mCurrentPosition++
                    when{
                        mCurrentPosition<= questionList!!.size->{
                            setQuestion()
                        }
                        else -> {
                            val intent:Intent = Intent(this,ScoreBoardActivity::class.java)
                            intent.putExtra(Constants.correct_answer, mCorrectAns.toString())
                            intent.putExtra(Constants.user_name,mUserName)
                            intent.putExtra(Constants.total_answer,questionList!!.size.toString())
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    if(questionList!![mCurrentPosition-1].correctAns!=mSelectedOptionNum){
                        answerView(mSelectedOptionNum,R.drawable.wrong_option_drawable)
                    }
                    else{
                        mCorrectAns++
                    }
                    answerView(questionList!![mCurrentPosition-1].correctAns,R.drawable.correct_option_drawable)
                    if(mCurrentPosition== questionList!!.size){
                        bind.btnSubmit.text = "FININSH"
                    }else{
                        bind.btnSubmit.text ="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionNum=0
                }
            }
        }
    }
    private fun answerView(selectedOption:Int,drawableSelected:Int){
        when(selectedOption){
            1->{
                bind.tvOptionOne.background = ContextCompat.getDrawable(
                    this,
                    drawableSelected
                )
            }
            2->{
                bind.tvOptionTwo.background = ContextCompat.getDrawable(
                    this,
                    drawableSelected
                )
            }
            3->{
                bind.tvOptionThree.background = ContextCompat.getDrawable(
                    this,
                    drawableSelected
                )
            }
            4->{
                bind.tvOptionFour.background = ContextCompat.getDrawable(
                    this,
                    drawableSelected
                )
            }
        }
    }
}