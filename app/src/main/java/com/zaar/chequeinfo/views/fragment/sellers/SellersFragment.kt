package com.zaar.chequeinfo.views.fragment.sellers

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zaar.chequeinfo.R
import com.zaar.chequeinfo.databinding.FragmentSellersBinding
import com.zaar.chequeinfo.utilities.functions.FuncNavigation.toNextFragment

class SellersFragment : Fragment() {

    private val viewModel: SellersViewModel by viewModels()
    private var _binding: FragmentSellersBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException(
            "Binding for SellersFragment must not be null"
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentSellersBinding.inflate(inflater).let {
            _binding = it
            _binding?.root
        } ?: inflater.inflate(R.layout.fragment_information, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initVariable()
        initView()
        initObserve()
    }

    private fun initVariable() {

    }

    private fun initView() {

    }

    private fun initObserve() {
        initObserveModel()
        initObserveView()
    }

    private fun initObserveModel() {

    }

    private fun initObserveView() {
        btnBackOnClick()
    }

    private fun btnBackOnClick() {
        binding.btnBack.setOnClickListener {
            toNextFragment(
                R.id.action_sellersFragment_to_mainMenuFragment2,
                Bundle(),
                findNavController()
            )
        }
    }
}