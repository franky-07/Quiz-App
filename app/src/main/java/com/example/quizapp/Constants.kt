package com.example.quizapp

object Constants {

        const val user_name:String = "USER_NAME"
        const val correct_answer:String = "CORRECT_ANSWER"
        const val total_answer:String = "TOTAL_ANSWER"
    fun getQuestion():ArrayList<Questions>{
        val questionList=ArrayList<Questions>()
        var que = Questions(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1
        )

        questionList.add(que)

        que = Questions(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        questionList.add(que)

        que = Questions(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )

        questionList.add(que)

        que = Questions(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )

        questionList.add(que)

        que = Questions(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )

        questionList.add(que)

        que = Questions(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )

        questionList.add(que)

        que = Questions(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )

        questionList.add(que)

        que = Questions(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )

        questionList.add(que)

        que = Questions(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )

        questionList.add(que)
        return questionList
    }
}