package com.udacity.shoestore.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ActivityViewModel
import timber.log.Timber

class DetailFragment : Fragment() {

    private lateinit var binding: DetailFragmentBinding
    private val mViewModel by activityViewModels<ActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.detail_fragment, container, false)
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListingFragment()) }

        binding.saveButton.setOnClickListener {
            outInfo()
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListingFragment())
        }


        return binding.root
    }

    private fun outInfo() {
        val name = binding.shoeNameEditText.text.toString()
        val size  = binding.sizeEditText.text.toString().toDouble()
        val company = binding.companyEditText.text.toString()
        val description = binding.descriptionEditText.text.toString()

        val newShoe = Shoe(name, size, company, description)
        mViewModel.addToList(newShoe)

    }

}