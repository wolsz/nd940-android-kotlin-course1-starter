package com.udacity.shoestore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding
import com.udacity.shoestore.databinding.ListingFragmentBinding


class ListingFragment : Fragment() {

    private lateinit var binding: ListingFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.listing_fragment, container, false)

        binding.detailFloatingab.setOnClickListener {
            findNavController().navigate(ListingFragmentDirections.actionListingFragmentToDetailFragment())
        }

        return binding.root
    }

}