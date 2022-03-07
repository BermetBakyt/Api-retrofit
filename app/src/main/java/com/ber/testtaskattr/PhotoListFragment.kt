package com.ber.testtaskattr

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ber.testtaskattr.databinding.FragmentMainBinding

class PhotoListFragment: Fragment(R.layout.fragment_photo_list) {
    private lateinit var listener: Navigation
    private val binding get() = _binding!!
    private var _binding : FragmentMainBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainBinding.bind(view)
    }
}