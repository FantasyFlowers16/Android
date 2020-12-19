package com.example.project_study.ui.mvp.main

import com.example.project_study.data.objects.Recipe

interface IMainView {
    fun showInfo(item: String)
    fun showList(list: List<Recipe>)
    fun showLoader(flag: Boolean)
    fun showError(message: String)
}

interface IMainPresenter {
    fun init()
    fun destroy()
    fun refresh()
}