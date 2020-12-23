package com.example.project_study.ui.mvp.details

import com.example.project_study.data.objects.Recipe

interface IDetailsView {
    fun showItem(item: Recipe)
    fun showLoad(flag: Boolean)
    fun showEr(message: String)
    fun getId(list: List<Recipe>)


}

interface IDetailsPresenter {
    fun init(id: String)
    fun destroy()
    fun refresh()
}