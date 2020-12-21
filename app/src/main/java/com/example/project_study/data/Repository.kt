package com.example.project_study.data

import android.util.Log
import com.example.project_study.App
import com.example.project_study.data.objects.Recipe
import com.example.project_study.data.objects.Recipes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun fetchRecipe(
        uuid: String,
        onResult: (Recipe) -> Unit,
        onError: (String) -> Unit,
    ) {
        App.networkService.fetchRecipe(uuid).enqueue(
            object : Callback<Recipe> {
                override fun onResponse(call: Call<Recipe>, response: Response<Recipe>) {
                    onResult.invoke(response.body()!!)
                }

                override fun onFailure(call: Call<Recipe>, t: Throwable) {
                    onError.invoke(t.message!!)
                }

            }
        )
    }


    fun fetchRecipeList(
        onResult: (Recipes) -> Unit,
        onError: (String) -> Unit,
    ) {
        App.networkService.fetchRecipes().enqueue(
                object : Callback<Recipes> {
                    override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                        onResult.invoke(response.body()!!)
                    }
                    override fun onFailure(call: Call<Recipes>, t: Throwable) {
                        onError.invoke(t.message!!)
                    }
                }
        )
    }


}