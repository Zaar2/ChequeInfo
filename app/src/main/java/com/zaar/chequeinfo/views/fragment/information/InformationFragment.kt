package com.zaar.chequeinfo.views.fragment.information

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zaar.chequeinfo.R
import com.zaar.chequeinfo.databinding.FragmentInformationBinding
import com.zaar.chequeinfo.utilities.functions.FuncNavigation.toNextFragment

class InformationFragment : Fragment() {

    private val viewModel: InformationViewModel by viewModels()
    private var _binding: FragmentInformationBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException(
            "Binding for InformationFragment must not be null"
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentInformationBinding.inflate(inflater).let {
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
                R.id.action_informationFragment_to_mainMenuFragment2,
                Bundle(),
                findNavController()
            )
        }
    }
}