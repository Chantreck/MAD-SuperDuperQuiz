package com.chantreck.superduperquiz.ui.quiz_list

import com.chantreck.superduperquiz.domain.dto.Quiz

data class QuizListUiState(
    val isListEmpty: Boolean = true,
    val list: List<Quiz>,
    val error: String? = null,
)
