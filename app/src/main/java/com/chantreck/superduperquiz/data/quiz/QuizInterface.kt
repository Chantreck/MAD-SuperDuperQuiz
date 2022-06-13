package com.chantreck.superduperquiz.data.quiz

import com.chantreck.superduperquiz.data.quiz.dto.QuizResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizInterface {
    @GET("/quizzes")
    fun getQuizList(): Call<List<QuizResponse>>

    @GET("/quizzes")
    fun getCategoryQuizList(@Query("categoryId") categoryId: String): Call<List<QuizResponse>>
}