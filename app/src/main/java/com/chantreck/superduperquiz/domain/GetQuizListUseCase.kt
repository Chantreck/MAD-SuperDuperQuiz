package com.chantreck.superduperquiz.domain

import com.chantreck.superduperquiz.data.quiz.QuizController
import com.chantreck.superduperquiz.data.quiz.dto.QuizResponse
import com.chantreck.superduperquiz.data.retrofit.OnFailureHandler

class GetQuizListUseCase(private val handler: OnFailureHandler) {
    private val controller = QuizController(handler)

    fun getQuizList(categoryId: String? = null, onSuccess: (List<QuizResponse>) -> Unit) {
        try {
            if (categoryId == null) {
                controller.getQuizList { response ->
                    onSuccess(response)
                }
            } else {
                //TODO запрос на получение викторин категории
                /*controller.getCategoryQuizList(categoryId) { response ->
                    onSuccess(response)
                }*/
            }
        } catch (e: Exception) {
            val message = e.message ?: return
            handler.onFailure(message)
        }
    }
}