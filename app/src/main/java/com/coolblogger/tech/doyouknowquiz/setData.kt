package com.coolblogger.tech.doyouknowquiz

object setData {

    const val name:String="name"
    const val score:String="0"

fun getQuesion():ArrayList<QuestionData>{
var que:ArrayList<QuestionData> = arrayListOf()
    var q1 = QuestionData(
        "The combination of operating system and processor in a compute is referred to as computers",
        1,
        "Minimum requirements",
        "Specifications",
        "Platform",
        "Firmware",
        3
    )
    var q2 = QuestionData(
        "What is the abbreviation of HTML?",
        2,
        "Hyper Tag Markup Language",
        "Hyper Text Markup Language",
        "Hyper Text Main Language",
        "Hyper Tag Main Language",
        2
    )
    var q3 = QuestionData(
        "_____ are used to allow the user to select one of the options displayed.",
        3,
        "Radio buttons",
        " Text boxes",
        " Check boxes",
        "Password controls",
        1
    )
   var q4 = QuestionData(
        "The image tag is always used with _____ attribute.",
        4,
        "Size",
        "SRC",
        "Color",
        "Font",
        2
    )
   var q5 = QuestionData(
        "RGB value for Red is ",
        5,
        "FFOOFF",
        "FFFFFF",
        "FFOOOO",
        "FFFFOO",
        3
    )

    que.add(q1)
    que.add(q2)
    que.add(q3)
    que.add(q4)
    que.add(q5)
    return que

}

}