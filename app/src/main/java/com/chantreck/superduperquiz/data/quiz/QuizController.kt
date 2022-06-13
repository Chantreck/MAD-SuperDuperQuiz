package com.chantreck.superduperquiz.data.quiz

import com.chantreck.superduperquiz.data.quiz.dto.QuizResponse
import com.chantreck.superduperquiz.data.retrofit.Network
import com.chantreck.superduperquiz.data.retrofit.OnFailureHandler
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuizController(private val handler: OnFailureHandler) {
    private val api = Network.authorizedRetrofit.create(QuizInterface::class.java)

    fun getQuizList(onSuccess: (List<QuizResponse>) -> Unit) {
        api.getQuizList().enqueue(object : Callback<List<QuizResponse>> {
            override fun onResponse(
                call: Call<List<QuizResponse>>,
                response: Response<List<QuizResponse>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { onSuccess(it) }
                } else {
                    onFailure(response)
                }
            }

            override fun onFailure(call: Call<List<QuizResponse>>, t: Throwable) {
                onFailure(t)
            }
        })
    }

    private fun <T> onFailure(response: Response<T>) {
        val errorBody = response.code().toString()
        handler.onFailure("Ошибка $errorBody")
    }

    private fun onFailure(t: Throwable) {
        val message = t.message ?: return
        handler.onFailure(message)
    }
}