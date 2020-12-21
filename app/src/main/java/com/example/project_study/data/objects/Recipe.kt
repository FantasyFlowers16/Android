package com.example.project_study.data.objects

import com.google.gson.annotations.SerializedName
data class Recipes (
    @SerializedName("recipes")
    val recipes: List<Recipe>

)
data class Recipe(

    @SerializedName("uuid")
    val uuid: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("images")
    val images: List<String>,

    @SerializedName("description")
    val description: String,

    @SerializedName("instructions")
    val instructions: String,

    @SerializedName("difficulty")
    val difficulty: Int
)
