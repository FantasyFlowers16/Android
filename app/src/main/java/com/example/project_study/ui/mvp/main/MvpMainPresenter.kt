package com.example.project_study.ui.mvp.main

import android.view.View
import com.example.project_study.App

class MvpMainPresenter(private var view: IMainView?) : IMainPresenter{
    override fun init() {
        fetchData()
    }

    private fun fetchData(){
        App.repository.fetchRecipeList(
                onError = {view?.showError(it)},
                onResult = {
                    view?.showList(it)
                    view?.showLoader(false)
                }
        )

    }
    override fun destroy() {
       view = null
    }

    override fun refresh() {
        view?.showLoader(true)
        fetchData()
    }

}