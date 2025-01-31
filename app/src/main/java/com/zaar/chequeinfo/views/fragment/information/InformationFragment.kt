package com.zaar.chequeinfo.views.fragment.information

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.zaar.chequeinfo.R
import com.zaar.chequeinfo.databinding.FragmentInformationBinding
import com.zaar.chequeinfo.utilities.functions.FuncNavigation.toNextFragment

class InformationFragment : Fragment() {

    private var model: InformationViewModel? = null
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
        model = ViewModelProvider(
            requireActivity(),
            InformationVmFactory(
            )
        )[InformationViewModel::class.java]
    }

    private fun initView() {
        model?.getSummarizedInfo()
    }

    private fun initObserve() {
        initObserveModel()
        initObserveView()
    }

    private fun initObserveModel() {
        model?.ldFirstDay()?.observe(viewLifecycleOwner) {
            binding.statInfInformationFragment.tvValueFirstDateUploadActivity.text = it
        }
        model?.ldLastDay()?.observe(viewLifecycleOwner) {
            binding.statInfInformationFragment.tvValueLastDateUploadActivity.text = it
        }
        model?.ldCountCheques()?.observe(viewLifecycleOwner) {
            binding.statInfInformationFragment.tvValueChequesUploadActivity.text = it
        }
        model?.ldCountRecords()?.observe(viewLifecycleOwner) {
            binding.statInfInformationFragment.tvValueRecordsUploadActivity.text = it
        }
        model?.ldCountGoods()?.observe(viewLifecycleOwner) {
            binding.statInfInformationFragment.tvValueGoodsUploadActivity.text = it
        }
        model?.ldCountSellers()?.observe(viewLifecycleOwner) {
            binding.statInfInformationFragment.tvValueSellersUploadActivity.text = it
        }
        model?.ldTotalCost()?.observe(viewLifecycleOwner) {
            binding.statInfInformationFragment.tvValueTotalCostUploadActivity.text = it
        }
        model?.ldAvrCost()?.observe(viewLifecycleOwner) {
            binding.statInfInformationFragment.tvValueAvrCostUploadActivity.text = it
        }
    }

    private fun initObserveView() {
        btnBackOnClick()
        btnClearDatabase()
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

    private fun btnClearDatabase() {
        binding.btnClearDatabase.setOnClickListener {
            model?.clearDatabase()
            model?.getSummarizedInfo()
        }
    }
}