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
import com.example.kotlinstudyguide.adapter.RecyclerViewAdapter
import com.example.kotlinstudyguide.models.KotlinRecyclerList
import com.example.kotlinstudyguide.viewmodel.MainActivityViewModel

class KotlinFragment : Fragment() {

    private lateinit var recyclerAdapter : RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_kotlin, container, false)

        initViewModel(view)
        initViewModel()
        return view
    }

    private fun initViewModel(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.kotlinRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decortion = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decortion)

        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getKotlinRecyclerListObserver().observe(this, Observer<KotlinRecyclerList> {
            if(it != null) {
                recyclerAdapter.setUpdatedKotlinData(it.kotlin_questions)
            } else {
                Toast.makeText(activity, "ERROR", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeKotlinApiCall()
    }

    companion object {
        fun newInstance() =
            KotlinFragment()
    }
}