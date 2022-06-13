package com.chantreck.superduperquiz.data.quiz.dto

import kotlinx.serialization.Serializable

@Serializable
data class Question(
    val id: String,
    val text: String,
    val answers: List<Answer>
)
