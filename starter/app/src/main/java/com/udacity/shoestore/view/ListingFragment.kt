package com.udacity.shoestore.view

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ItemLayoutBinding
import com.udacity.shoestore.databinding.ListingFragmentBinding
import com.udacity.shoestore.viewmodel.ActivityViewModel


class ListingFragment : Fragment() {

    private lateinit var binding: ListingFragmentBinding
    private lateinit var listBinding: ItemLayoutBinding
    private val mViewModel by activityViewModels<ActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.listing_fragment, container, false)

        binding.detailFloatingab.setOnClickListener {
            findNavController().navigate(ListingFragmentDirections.actionListingFragmentToDetailFragment())
        }

        setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        mViewModel.shoeList.observe(this.viewLifecycleOwner, Observer {
            adding()
        })



        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

    fun adding() {
        val outerLinearlayout = binding.detailLinearlayout

        val list = mViewModel.shoeList.value
        if (list != null) {
            for (itemShoe in list) {
                listBinding = DataBindingUtil.inflate(
                    layoutInflater,
                    R.layout.item_layout,
                    outerLinearlayout,
                    false
                )
                listBinding.shoe = itemShoe
                outerLinearlayout.addView(listBinding.root)
            }
        }
    }
}