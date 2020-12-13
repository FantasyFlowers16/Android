package com.example.project_study

import android.app.Application
import com.example.project_study.data.Api
import com.example.project_study.data.NetworkService
import com.example.project_study.data.Repository

class App : Application() {
    companion object{
        lateinit var networkService: Api
        lateinit var repository: Repository

        fun initNetworkService(network: Api) {
            networkService = network
        }
        fun initRepository(rep: Repository) {
            repository = rep
        }

    }

    override fun onCreate() {
        super.onCreate()
        initNetworkService(NetworkService.networkService())
        initRepository(Repository())
    }
}