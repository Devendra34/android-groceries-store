package com.hieuwu.groceriesstore.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.hieuwu.groceriesstore.R
import com.hieuwu.groceriesstore.databinding.FragmentSigninBinding
import com.hieuwu.groceriesstore.presentation.viewmodels.SignInViewModel
import com.hieuwu.groceriesstore.presentation.viewmodels.factory.ViewModelFactory


class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSigninBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentSigninBinding>(
            inflater, R.layout.fragment_signin, container, false
        )

        binding.signUpTextview.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_signInFragment_to_signUpFragment)
        }

        val viewModelFactory = ViewModelFactory(null, null)
        val signInViewModel = ViewModelProvider(this, viewModelFactory)
            .get(SignInViewModel::class.java)
        binding.signInViewModel = signInViewModel

        binding.lifecycleOwner = this
        return binding.root
    }

}
