package com.chantreck.superduperquiz.domain.dto

import com.chantreck.superduperquiz.data.quiz.dto.QuizResponse

data class Quiz(
    val id: String,
    val title: String,
    val description: String,
    val category: String,
    val difficulty: String,
    val authorNickname: String
)

fun QuizResponse.toRaw(): Quiz {
    return Quiz(
        id = id,
        title = name,
        description = description,
        category = category,
        difficulty = difficulty.translate,
        authorNickname = author
    )
}