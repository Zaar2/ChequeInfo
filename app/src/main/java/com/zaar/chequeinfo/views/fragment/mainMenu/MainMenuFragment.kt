package com.zaar.chequeinfo.views.fragment.mainMenu

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.zaar.chequeinfo.R
import com.zaar.chequeinfo.app.App
import com.zaar.chequeinfo.databinding.FragmentMainMenuBinding
import com.zaar.chequeinfo.utilities.functions.FuncNavigation.toNextFragment

class MainMenuFragment : Fragment() {

    private val model: MainMenuViewModel by viewModels()
    private var _binding: FragmentMainMenuBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException(
            "Binding for MainMenuFragment must not be null"
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        FragmentMainMenuBinding.inflate(inflater).let {
            _binding = it
            _binding?.root
        } ?: inflater.inflate(R.layout.fragment_main_menu, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        App.getAppComponent().injectMainMenuFragment(this)

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
        btnGoodsOnClick()
        btnSellersOnClick()
        btnChequesOnClick()
        btnInformationOnClick()
    }

    private fun btnChequesOnClick() {
        binding.btnMainCheques.setOnClickListener {
            toNextFragment(
                R.id.action_mainMenuFragment2_to_chequesFragment,
                Bundle(),
                findNavController()
            )
        }
    }

    private fun btnSellersOnClick() {
        binding.btnMainSellers.setOnClickListener {
            toNextFragment(
                R.id.action_mainMenuFragment2_to_sellersFragment,
                Bundle(),
                findNavController()
            )
        }
    }

    private fun btnGoodsOnClick() {
        binding.btnMainGoods.setOnClickListener {
            toNextFragment(
                R.id.action_mainMenuFragment2_to_goodsFragment,
                Bundle(),
                findNavController()
            )
        }
    }

    private fun btnInformationOnClick() {
        binding.btnMainInformation.setOnClickListener {
            toNextFragment(
                R.id.action_mainMenuFragment2_to_informationFragment,
                Bundle(),
                findNavController()
            )
        }
    }
}