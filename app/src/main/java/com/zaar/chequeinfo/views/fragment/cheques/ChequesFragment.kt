package com.zaar.chequeinfo.views.fragment.cheques

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zaar.chequeinfo.R
import com.zaar.chequeinfo.databinding.FragmentChequesBinding
import com.zaar.chequeinfo.utilities.functions.FuncNavigation.toNextFragment

class ChequesFragment : Fragment() {

    private var model: ChequesViewModel? = null
    private var _binding: FragmentChequesBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException(
            "Binding for ChequesFragment must not be null"
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentChequesBinding.inflate(inflater).let {
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
                R.id.action_chequesFragment_to_mainMenuFragment2,
                Bundle(),
                findNavController()
            )
        }
    }
}