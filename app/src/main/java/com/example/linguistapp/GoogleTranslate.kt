package com.example.linguistapp

import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Body
import retrofit2.Call
import retrofit2.http.Headers

interface GoogleTranslate {

    @Headers("Content-Type: application/json")
    @POST("language/translate/v2")
    fun translateText(
        @Query("key") apiKey: String,
        @Body translateRequest: TranslateRequest
    ): Call<TranslateResponse>

    data class TranslateRequest(
        val q: String, // Query text
        val source: String, // Source language
        val target: String, // Target language
        val format: String = "text" // Text format
    )

    data class TranslateResponse(
        val data: TranslationsData
    )

    data class TranslationsData(
        val translations: List<TranslationItem>
    )

    data class TranslationItem(
        val translatedText: String
    )
}