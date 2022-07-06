package com.example.securekey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_advanced_kotlin.activity.model.Post
import com.example.android_mvc.adapter.PostAdapter
import com.example.android_mvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var viewModel: MainViewModel

    var serverKey = BuildConfig.SERVER_KEY
    var smsKey = BuildConfig.SMS_KEY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var application = Application()
        Log.d("@@@MainActivity", serverKey)
        Log.d("@@@MainActivity", smsKey)
        Log.d("@@@MainActivity", application.getPublicKey().toString())
        Log.d("@@@MainActivity", application.getPrivateKey().toString())

        initViews()
    }

    private fun initViews() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))
        viewModel.apiPostList()

//        lifecycleScope.launchWhenCreated {
//            viewModel.postList.collectLatest {
//                refreshAdapter(it)
//            }
//        }

        viewModel.allPosts.observe(this, Observer {
            refreshAdapter(it)
        })
    }

    private fun refreshAdapter(posters: ArrayList<Post>) {
        val adapter = PostAdapter(this, posters)
        recyclerView.setAdapter(adapter)
    }
}