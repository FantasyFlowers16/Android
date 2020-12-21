package com.example.project_study.ui.mvp.main

import CustomAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project_study.R
import com.example.project_study.data.objects.Recipe
import com.google.android.material.snackbar.Snackbar

class MvpMainActivity : AppCompatActivity(), IMainView{
    lateinit var presenter: MvpMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initPresenter()
        presenter.init()

    }

        private fun initViews(){
            findViewById<ProgressBar>(R.id.mvpProgressBar).visibility = View.VISIBLE
        }
        private fun initPresenter(){
            presenter = MvpMainPresenter(this)
        }


    override fun showInfo(item: String) {
        Snackbar.make(
                findViewById(R.id.main_root),
                item,
                Snackbar.LENGTH_LONG)
        Log.i("TAg", item)
        Toast.makeText(this,item,Toast.LENGTH_LONG).show()
    }

    override fun showList(list: List<Recipe>) {
        val recyclerView = findViewById<RecyclerView>(R.id.mvpMainRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //TODO Adapter
        recyclerView.adapter = CustomAdapter(list, onClick = {
            val intent = Intent(this, MvpMainActivity::class.java)
            intent.putExtra("id", it)
            startActivity(intent)
        })
    }


    override fun showLoader(flag: Boolean) {
        if (flag) {
            Toast.makeText(this, "hello", Toast.LENGTH_LONG).show()
            Log.i("TAg", "load")
            findViewById<ProgressBar>(R.id.mvpProgressBar).visibility = View.VISIBLE
            findViewById<RecyclerView>(R.id.mvpMainRecycler).visibility = View.GONE
        } else {
            Toast.makeText(this, "hello2", Toast.LENGTH_LONG).show()
            Log.i("TAg", "noload")
            findViewById<ProgressBar>(R.id.mvpProgressBar).visibility = View.GONE
            findViewById<RecyclerView>(R.id.mvpMainRecycler).visibility = View.VISIBLE
        }
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
