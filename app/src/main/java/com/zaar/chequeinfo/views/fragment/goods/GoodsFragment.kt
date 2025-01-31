package com.zaar.chequeinfo.views.fragment.goods

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zaar.chequeinfo.R
import com.zaar.chequeinfo.databinding.FragmentGoodsBinding
import com.zaar.chequeinfo.utilities.functions.FuncNavigation.toNextFragment

class GoodsFragment : Fragment() {

    private val viewModel: GoodsViewModel by viewModels()
    private var _binding: FragmentGoodsBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException(
            "Binding for GoodsFragment must not be null"
        )
//    val countingIdlingResource = CountingIdlingResource("goodsCreateViews")

//    init {
//        countingIdlingResource.increment()
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentGoodsBinding.inflate(inflater).let {
            _binding = it
            _binding?.root
        } ?: inflater.inflate(R.layout.fragment_information, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initVariable()
        initView()
        initObserve()
    }

    override fun onResume() {
        super.onResume()
//        countingIdlingResource.decrement()
    }

    override fun onPause() {
        super.onPause()
//        countingIdlingResource.decrement()
    }

    private fun initVariable() {
        this::class.java.name
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
                R.id.action_goodsFragment_to_mainMenuFragment2,
                Bundle(),
                findNavController()
            )
        }
    }
}