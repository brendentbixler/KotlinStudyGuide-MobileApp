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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinstudyguide.R
import com.example.kotlinstudyguide.adapter.ThirdAdapter
import com.example.kotlinstudyguide.models.ThirdRecyclerList
import com.example.kotlinstudyguide.viewmodel.MainActivityViewModel

class ThirdPartyFragment : Fragment() {

    private lateinit var recyclerAdapter: ThirdAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_third_party, container, false)
        initViewModel(view)
        initViewModel()
        return view
    }

    private fun initViewModel(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.thirdRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = ThirdAdapter()
        recyclerView.adapter = recyclerAdapter
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun initViewModel() {
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getThirdRecyclerListObserver().observe(this, Observer<ThirdRecyclerList> {
            if(it != null) {
                recyclerAdapter.setUpdatedThirdData(it.third_party_libraries)
            } else {
                Toast.makeText(activity, "ERROR", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeThirdApiCall()
    }

    companion object {
        fun newInstance() =
            ThirdPartyFragment()
    }
}