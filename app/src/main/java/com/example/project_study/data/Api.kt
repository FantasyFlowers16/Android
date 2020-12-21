package com.example.project_study.data

import com.example.project_study.data.objects.Recipe
import com.example.project_study.data.objects.Recipes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("recipes")
    fun fetchRecipes(): Call<Recipes>

    @GET("recipes/{uuid}")
    fun fetchRecipe(@Path("uuid") id: String): Call<Recipe>

}