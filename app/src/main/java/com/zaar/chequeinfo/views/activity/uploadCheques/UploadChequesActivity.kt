package com.zaar.chequeinfo.views.activity.uploadCheques

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.zaar.chequeinfo.R
import com.zaar.chequeinfo.app.App
import com.zaar.chequeinfo.model.dataSource.otherApp.ParsedData
import com.zaar.chequeinfo.databinding.ActivityUploadChequesBinding
import javax.inject.Inject

class UploadChequesActivity : AppCompatActivity() {
    private var model: UploadChequesViewModel? = null

    @Inject
    lateinit var parsedData: ParsedData

    private var _binding: ActivityUploadChequesBinding? = null
    private val binding
        get() = _binding ?: throw IllegalStateException(
            "Binding for UploadChequesActivity must not be null"
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityUploadChequesBinding.inflate(layoutInflater)
        setContentView(_binding!!.root)

        App.getAppComponent()
            .getSubCompUploadDataFactory()
            .create(
                intent
            )
            .injectUploadActivity(
                this
            )

        initVariable()
        initView()
        initObserve()
    }

    private fun initVariable() {
        model = ViewModelProvider(
            this,
            UploadChequesVMFactory(
                applicationContext,
                parsedData
            )
        ).get()
    }

    private fun initView() {
        binding.statInfUploadActivity.root.visibility = View.VISIBLE
        binding.statInfoUploadedCheques.root.visibility = View.GONE
        model?.getSummarizedInformation()
    }

    private fun initObserve() {
        initObserveModel()
        initObserveView()
    }

    private fun initObserveModel() {
        model?.ldFirstDay()?.observe(this) {
            binding.statInfUploadActivity.tvValueFirstDateUploadActivity.text = it
        }
        model?.ldLastDay()?.observe(this) {
            binding.statInfUploadActivity.tvValueLastDateUploadActivity.text = it
        }
        model?.ldCountCheques()?.observe(this) {
            binding.statInfUploadActivity.tvValueChequesUploadActivity.text = it
        }
        model?.ldCountRecords()?.observe(this) {
            binding.statInfUploadActivity.tvValueRecordsUploadActivity.text = it
        }
        model?.ldCountGoods()?.observe(this) {
            binding.statInfUploadActivity.tvValueGoodsUploadActivity.text = it
        }
        model?.ldCountSellers()?.observe(this) {
            binding.statInfUploadActivity.tvValueSellersUploadActivity.text = it
        }
        model?.ldTotalCost()?.observe(this) {
            binding.statInfUploadActivity.tvValueTotalCostUploadActivity.text = it
        }
        model?.ldAvrCost()?.observe(this) {
            binding.statInfUploadActivity.tvValueAvrCostUploadActivity.text = it
        }

//        model?.ldCheques()?.observe(this) {
//            binding.statInfUploadActivity.tvDescription.append("cheques upload is ok\n")
//            binding.statInfUploadActivity.tvDescription.append(listToStr(it))
//            binding.statInfUploadActivity.tvDescription.append("\n")
//        }
//        model?.ldTbls()?.observe(this) {
//            binding.statInfUploadActivity.tvDescription.append("obtaining tbl of database name is ok")
//            binding.statInfUploadActivity.tvDescription.append(listToStr(it))
//            binding.statInfUploadActivity.tvDescription.append("\n")
//        }
        model?.ldMapResult()?.observe(this) { mapResult ->
            binding.statInfoUploadedCheques.root.visibility = View.VISIBLE
            mapResult.forEach { (index, value) ->
                when (index) {
                    R.string.lblChequesUploaded -> {
                        binding.statInfoUploadedCheques.tvLabelChequesUploaded.visibility =
                            View.VISIBLE
                        binding.statInfoUploadedCheques.tvValueChequesUploaded
                    }

                    R.string.lblRecordsUploaded -> {
                        binding.statInfoUploadedCheques.tvLabelRecordsUploaded.visibility =
                            View.VISIBLE
                        binding.statInfoUploadedCheques.tvValueRecordsUploaded
                    }

                    R.string.lblChequesRejected -> {
                        binding.statInfoUploadedCheques.tvLabelChequesRejected.visibility =
                            View.VISIBLE
                        binding.statInfoUploadedCheques.tvValueChequesRejected
                    }

                    else -> {
//                        binding.statInfoUploadedCheques.root.visibility = View.GONE
                        binding.statInfUploadActivity.tvDescription
                    }
                }.apply {
                    visibility = View.VISIBLE
                    text = "$value"
                }
            }
        }
    }

    private fun <T> listToStr(list: List<T>): String =
        StringBuilder().let {
            it.append("count record: ")
            it.append(list.size)
        }.toString()

    private fun initObserveView() {
        btnToMenuOnClick()
        btnSaveToDatabaseOnClick()
    }

    private fun btnSaveToDatabaseOnClick() {
        binding.btnSaveToDatabase.setOnClickListener {
            model?.saveCheques()
        }
    }

    private fun btnToMenuOnClick() {
//        binding.btnBack.setOnClickListener {
//        }
    }
}