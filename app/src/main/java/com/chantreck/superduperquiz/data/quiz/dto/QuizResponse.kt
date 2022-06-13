package com.chantreck.superduperquiz.data.quiz.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuizResponse(
    val id: String,
    val name: String,
    val description: String,

    @SerialName("difficult")
    val difficulty: QuizDifficulty,

    @SerialName("categoryId")
    val category: String,

    val results: List<String>
)
