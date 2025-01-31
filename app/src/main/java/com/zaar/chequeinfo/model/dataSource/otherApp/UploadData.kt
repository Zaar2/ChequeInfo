package com.zaar.chequeinfo.model.dataSource.otherApp

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import java.io.BufferedReader
import java.io.FileNotFoundException
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.nio.file.Path

class UploadData(
    intent: Intent,
    private val context: Context,
    private var uri: Uri? = null,
    private var verCurrentAndroidCode: Int = Build.VERSION.SDK_INT
) {
    val selData: String

    init {
        uri = getUri(intent)
        selData = uri?.let { getString(it) } ?: ""
    }

    private fun getUri(intent: Intent): Uri? =
        if (intent.action != null) {
            when {
                //Build.VERSION_CODES.TIRAMISU==33
                (verCurrentAndroidCode >= Build.VERSION_CODES.TIRAMISU) -> {
                    intent.clipData?.itemCount?.let { count ->
                        for (i in 0 until count) {
                            intent.clipData?.getItemAt(i)?.uri
                                .takeIf { it != null }
                                ?.also { return@let it }
                        }
                        null
                    }
                }

                else -> intent.getParcelableExtra("DATA")
            }
        } else null

    private fun getString(uri: Uri): String =
        try {
            context.contentResolver?.openInputStream(uri)?.let { inpStream ->
                var line = ""
                StringBuilder().also { builder ->
                    BufferedReader(
                        InputStreamReader(inpStream, StandardCharsets.UTF_8)
                    ).let { bufReader ->
                        try {
                            // читаем содержимое
                            while ((bufReader.readLine()?.also { line = it }) != null) {
                                builder.append(line)
                            }
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                    inpStream.close()
                }.toString()
            } ?: ""
        } catch (e: FileNotFoundException) {
            """
                [{}]
            """.trimIndent()
        }
}