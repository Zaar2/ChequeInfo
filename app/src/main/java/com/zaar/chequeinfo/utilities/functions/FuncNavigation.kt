package com.zaar.chequeinfo.utilities.functions

import android.os.Bundle
import android.widget.Button
import androidx.navigation.NavController
import com.zaar.chequeinfo.R
import com.zaar.chequeinfo.views.fragment.cheques.ChequesFragment
import com.zaar.chequeinfo.views.fragment.goods.GoodsFragment
import com.zaar.chequeinfo.views.fragment.information.InformationFragment
import com.zaar.chequeinfo.views.fragment.sellers.SellersFragment

object FuncNavigation {

    fun toNextFragment(actionId: Int, bundle: Bundle, navController: NavController) {
        navController.navigate(
            actionId, bundle
        )
    }

    fun btnBackOnClick(button: Button, nameClass: String, bundle: Bundle, navController: NavController){
        button.setOnClickListener {
            backToMainMenu(nameClass, bundle, navController)
        }
    }

    private fun backToMainMenu(nameClass: String, bundle: Bundle, navController: NavController) {
        when (nameClass) {
            InformationFragment::class.java.name -> R.id.action_informationFragment_to_mainMenuFragment2
            ChequesFragment::class.java.name -> R.id.action_chequesFragment_to_mainMenuFragment2
            GoodsFragment::class.java.name -> R.id.action_goodsFragment_to_mainMenuFragment2
            SellersFragment::class.java.name -> R.id.action_sellersFragment_to_mainMenuFragment2
            else -> null
        }?.let { id ->
            navController.navigate(
                id, bundle
            )
        }
    }
}