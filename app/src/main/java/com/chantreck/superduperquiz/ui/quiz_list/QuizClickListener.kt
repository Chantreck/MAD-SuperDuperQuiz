package com.chantreck.superduperquiz.ui.quiz_list

import com.chantreck.superduperquiz.data.QuizShortInfo

interface QuizClickListener {
    fun onClick(quiz: QuizShortInfo)
}