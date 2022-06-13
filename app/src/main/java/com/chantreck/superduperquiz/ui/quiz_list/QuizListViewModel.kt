package com.chantreck.superduperquiz.ui.quiz_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chantreck.superduperquiz.data.retrofit.OnFailureHandler
import com.chantreck.superduperquiz.domain.GetQuizListUseCase
import com.chantreck.superduperquiz.domain.dto.toRaw

class QuizListViewModel: ViewModel() {
    private val handler = object : OnFailureHandler {
        override fun onFailure(message: String) {
            TODO("Not yet implemented")
        }
    }
    private val useCase = GetQuizListUseCase(handler)

    private val _state = MutableLiveData<QuizListUiState>()
    val state: LiveData<QuizListUiState> get() = _state

    init {
        useCase.getQuizList { responseList ->
            val list = responseList.map { response -> response.toRaw() }
            if (list.isEmpty()) {
                _state.value = QuizListUiState(true, list)
            } else {
                _state.value = QuizListUiState(false, list)
            }
        }
    }
}