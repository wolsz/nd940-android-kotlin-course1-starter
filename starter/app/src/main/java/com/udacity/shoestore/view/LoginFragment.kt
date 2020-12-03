package com.udacity.shoestore.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListingFragmentBinding
import com.udacity.shoestore.databinding.LoginFragmentBinding
import com.udacity.shoestore.models.LoginState
import com.udacity.shoestore.viewmodel.ActivityViewModel


class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding
    private val mViewModel by activityViewModels<ActivityViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)

        binding.signinButton.setOnClickListener {
            saveLoginState()
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        binding.signupButton.setOnClickListener {
            saveLoginState()
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }

        return binding.root
    }

    private fun saveLoginState() {
        val userName = binding.usernameEdittext.text.toString()
        val password = binding.passwordEdittext.text.toString()
        mViewModel.loginState = LoginState(userName, password)
    }

}