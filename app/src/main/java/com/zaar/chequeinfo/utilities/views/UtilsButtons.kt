package com.zaar.chequeinfo.utilities.views

import android.content.Context
import android.content.res.ColorStateList
import android.widget.Button
import com.zaar.chequeinfo.R

object UtilsButtons {

    /**
     * button will be block,
     * background tint for this button will be replace with 'R.color.button_blocked'
     */
    @Deprecated(
        "this method is deprecated",
        ReplaceWith(
            "activeBtnOff(" +
                    "button: Button?, " +
                    "backgroundTintColorState: ColorStateList," +
                    " textColorStateList: ColorStateList,)"
        )
    )
    fun activeBtnOffBlock(button: Button?, context: Context) {
        activeBtnOff(
            button,
            context.getColorStateList(R.color.background_btn_blocked),
            context.getColorStateList(R.color.black)
        )
    }

    /**
     * @param button this button will be block
     * @param backgroundTintColorState tint for button will be replace with this -
     * context.getColorStateList(R.color.button_blocked)
     * @param textColorStateList text color for button will be replace with this -
     * context.getColorStateList(R.color.black)
     */
    fun activeBtnOff(
        button: Button?,
        backgroundTintColorState: ColorStateList,
        textColorStateList: ColorStateList,
    ) {
        button?.apply {
            isEnabled = false
            backgroundTintList = backgroundTintColorState
            setTextColor(textColorStateList)
            refreshDrawableState()
        }
    }

    /**
     * button will be unblock,
     * background tint for this button will be replace with 'R.color.bg_selector',
     * and text color will be replace with 'R.color.milk_background'
     */
    @Deprecated(
        "this method is deprecated",
        ReplaceWith("activeBtnOn(button: Button?, colorStateList: ColorStateList, context: Context)")
    )
    fun activeBtnOn(button: Button?, context: Context) {
        activeBtnOn(
            button,
            context.getColorStateList(R.color.bg_selector),
            context.getColorStateList(R.color.background_milk)
        )
    }

    /**
     * button will be unblock,
     * background tint for this button will be replace with 'backgroundTintColorState: ColorStateList' -
     * context.getColorStateList(R.color.bg_selector),
     * and text color will be replace with 'textColorStateList: ColorStateList' -
     * context.getColorStateList(R.color.milk_background)
     */
    fun activeBtnOn(
        button: Button?,
        backgroundTintColorState: ColorStateList,
        textColorStateList: ColorStateList
    ) {
        button?.apply {
            isEnabled = true
            backgroundTintList = backgroundTintColorState
            setTextColor(textColorStateList)
            refreshDrawableState()
        }
    }
}