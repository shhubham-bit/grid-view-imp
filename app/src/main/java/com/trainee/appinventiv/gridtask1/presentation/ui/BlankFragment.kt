package com.trainee.appinventiv.gridtask1.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.trainee.appinventiv.gridtask1.adapter.NewAdapter
import com.trainee.appinventiv.gridtask1.adapter.NumberAdapter
import com.trainee.appinventiv.gridtask1.databinding.FragmentBlankBinding
import com.trainee.appinventiv.gridtask1.model.AlphaNum
import com.trainee.appinventiv.gridtask1.presentation.MenuOperation
import com.trainee.appinventiv.gridtask1.presentation.viewModel.MainViewModel


class BlankFragment : Fragment() {

    private lateinit var binding : FragmentBlankBinding
    private lateinit var numberAdapter: NumberAdapter
    private var nameList : ArrayList<String> = ArrayList<String>()
    private val viewModel : MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()

    }

    private fun setAdapter() {
        viewModel.initializeList()
        nameList = viewModel.nameList

        binding.rvRecyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        val adapter = NewAdapter(nameList,requireContext())

        adapter.submitList(nameList)

        binding.rvRecyclerView.setHasFixedSize(true)

        binding.rvRecyclerView.adapter = adapter

    }

}