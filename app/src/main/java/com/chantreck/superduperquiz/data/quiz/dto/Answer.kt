package com.chantreck.superduperquiz.data.quiz.dto

import kotlinx.serialization.Serializable

@Serializable
data class Answer(
    val id: String,
    val text: String,
    val isRight: Boolean
)
