package com.coolblogger.tech.doyouknowquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity() {

    private var Name:String?=null
    private var score:Int=0

    private var currentPosition:Int = 1
    private var questionList:ArrayList<QuestionData>?=null
    private var selectedOption:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name=intent.getStringExtra(setData.name)

        questionList=setData.getQuesion()
        setQuestion()
        option1.setOnClickListener {
            selectedOptionStyle(option1,1)
        }

        option2.setOnClickListener {
            selectedOptionStyle(option2,2)
        }

        option3.setOnClickListener {
            selectedOptionStyle(option3,3)
        }
        option4.setOnClickListener {
            selectedOptionStyle(option4,4)
        }
        submitQuiz.setOnClickListener {
            if (selectedOption!=0){
                val question = questionList!![currentPosition-1]
                if (selectedOption!=question.correctAns){
                setColor(selectedOption,R.drawable.wrong_option)
                }else{
                    score++
                }
                setColor(question.correctAns,R.drawable.correct_option)
                if(currentPosition==questionList!!.size)
                    submitQuiz.text="FINISH"
                else
                    submitQuiz.text="Next Question"
            }else{
                currentPosition++
                when{
                    currentPosition<=questionList!!.size->{
                        setQuestion()
                    }else->{
//                    Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show()
                    var intent = Intent(this,result::class.java)
                    intent.putExtra(setData.name,Name.toString())
                    intent.putExtra(setData.score,score.toString())
                    intent.putExtra("total size", questionList!!.size.toString())
                    startActivity(intent)
                    finish()
                    }
                }
            }
            selectedOption=0
        }
    }
    fun setColor(opt: Int, color:Int){
        when(opt){
            1->{
                option1.background=ContextCompat.getDrawable(this,color)
            }
            2->{
                option2.background=ContextCompat.getDrawable(this,color)
            }
            3->{
                option3.background=ContextCompat.getDrawable(this,color)
            }
            4->{
                option4.background=ContextCompat.getDrawable(this,color)
            }
        }
    }
    private fun setQuestion() {
        // default question style
    val question = questionList!![currentPosition-1]
        setOptionStyle()

        progress.progress = currentPosition
        progress.max= questionList!!.size
        progressValue.text = "${currentPosition}" + "/" + "${questionList!!.size}"
        questionTxt.text = question.question
        option1.text=question.option_one
        option2.text=question.option_two
        option3.text=question.option_three
        option4.text=question.option_four

    }

    fun setOptionStyle(){
        // default style for option
var optionList:ArrayList<TextView> = arrayListOf()
        optionList.add(0,option1)
        optionList.add(0,option2)
        optionList.add(0,option3)
        optionList.add(0,option4)

        for (op in optionList){
            op.setTextColor(Color.parseColor("#555151"))
            op.background=ContextCompat.getDrawable(this,R.drawable.ques)
            op.typeface= Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view: TextView,opt:Int){
// When user will select any option then this function will call
        setOptionStyle()
        // here this function is call in this because
        // if user select two option both option will be blue so that's why we set it default
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.option_background)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }

}