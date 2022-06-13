package com.chantreck.superduperquiz.data.quiz.dto

import kotlinx.serialization.Serializable

@Serializable
data class QuizResponse(
    val id: String,
    val name: String,
    val description: String,
    val difficulty: QuizDifficulty,
    val category: String,
    val author: String,
    val questions: List<Question>
)
