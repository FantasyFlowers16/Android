package com.example.project_study.ui.mvp.details


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project_study.R
import com.example.project_study.data.objects.Recipe
import com.example.project_study.ui.mvp.main.MvpMainActivity


class MvpDetailsActivity : AppCompatActivity(), IDetailsView {
    lateinit var presenter: IDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        initViews()
        initPresenter()
        presenter.init()

    }

    private fun initViews() {
        findViewById<ProgressBar>(R.id.mvpProgressBar).visibility = View.VISIBLE
    }

    private fun initPresenter() {
        presenter = MvpDetailsPresenter(this)
    }

    override fun showItem(item: Recipe) {
        val uuid = findViewById<RecyclerView>(R.id.mvpMainRecycler)
        uuid.layoutManager = LinearLayoutManager(this)
//        uuid.adapter = CustomAdapter(Recipe, onClick = {
//            val intent = Intent(this, MvpMainActivity::class.java)
//            intent.putExtra("id", it)
//            startActivity(intent)
//        })
    }


    override fun showLoad(flag: Boolean) {
        if (flag) {
            findViewById<ProgressBar>(R.id.mvpProgressBar).visibility = View.VISIBLE
            findViewById<ConstraintLayout>(R.id.item_layout).visibility = View.GONE
        } else {
            findViewById<ProgressBar>(R.id.mvpProgressBar).visibility = View.GONE
            findViewById<ConstraintLayout>(R.id.item_layout).visibility = View.VISIBLE
        }
    }

    //
    override fun showEr(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun getId(id: String) {
        val uuid = findViewById<RecyclerView>(R.id.mvpMainRecycler)
        uuid.layoutManager = LinearLayoutManager(this)

//        uuid.adapter = CustomAdapter(Recipe, onClick = {
//            val intent = Intent(this, MvpMainActivity::class.java)
//            intent.putExtra("id", it)
//            startActivity(intent)
//        })
    }
}