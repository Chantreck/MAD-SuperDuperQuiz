package com.chantreck.superduperquiz.ui.quiz_list

import com.chantreck.superduperquiz.domain.dto.Quiz

interface QuizClickListener {
    fun onClick(quiz: Quiz)
}