package com.example.kotlinstudyguide.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudyguide.R
import com.example.kotlinstudyguide.adapter.AndroidAdapter
import com.example.kotlinstudyguide.adapter.RecyclerViewAdapter
import com.example.kotlinstudyguide.models.AndroidRecyclerList
import com.example.kotlinstudyguide.viewmodel.MainActivityViewModel

class AndroidFragment : Fragment() {

    private lateinit var recyclerAdapter : AndroidAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_android, container, false)

        initViewModel(view)
        initViewModel()
        return view
    }

    private fun initViewModel(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.androidRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decortion = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decortion)

        recyclerAdapter = AndroidAdapter()
        recyclerView.adapter = recyclerAdapter
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getAndroidRecyclerListObserver().observe(this, Observer<AndroidRecyclerList> {
            if(it != null) {
                recyclerAdapter.setUpdatedAndroidData(it.android_questions)
            } else {
                Toast.makeText(activity, "ERROR", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAndroidApiCall()
    }

    companion object {
        fun newInstance() =
            AndroidFragment()
    }
}