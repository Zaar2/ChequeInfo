package com.zaar.chequeinfo.model.dataSource.local.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.zaar.chequeinfo.model.dataSource.local.room.converter.ConverterDate
import com.zaar.chequeinfo.model.dataSource.local.room.dao.ChequeDao
import com.zaar.chequeinfo.model.dataSource.local.room.dao.DatabaseDao
import com.zaar.chequeinfo.model.dataSource.local.room.dao.ItemDao
import com.zaar.chequeinfo.model.dataSource.local.room.dao.ReceiptDao
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ChequeDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ItemDb
import com.zaar.chequeinfo.model.dataSource.local.room.entityDB.ReceiptDb
import java.io.File
import java.net.URI
import javax.inject.Inject
import kotlin.concurrent.Volatile
import kotlin.io.path.Path

@Database(
    version = 2,
    entities = [
        ChequeDb::class,
        ItemDb::class,
        ReceiptDb::class,
    ],
    exportSchema = false,
)
@TypeConverters(ConverterDate::class)
abstract class DatabaseChequeInf : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "dbChequeInfo.db"
//        "/storage/sdcard0/Download/111/Backup-1-16-01-2025.db"

        @Volatile
        private lateinit var INSTANCE: DatabaseChequeInf
        private var LOCK = Any()

        @Volatile
        private var _inst = false

        fun getInstance(context: Context): DatabaseChequeInf {
            if (!_inst) {
//            if (INSTANCE == null) {
                synchronized(LOCK) {
                    if (!_inst) {
//                    if (INSTANCE == null) {
                        try {
                            INSTANCE = Room.databaseBuilder(
                                context = context,
                                name = DATABASE_NAME,
                                klass = DatabaseChequeInf::class.java
                            )
//                            .createFromFile(File("/storage/sdcard0/Download/111/Backup-1-16-01-2025.db"))
                                .fallbackToDestructiveMigration()
                                .build()
                        } finally {
                            _inst = true
                        }
                    }
                }
            }
            return INSTANCE
        }
    }

    abstract fun getChequeDao(): ChequeDao
    abstract fun getItemDao(): ItemDao
    abstract fun getReceiptDao(): ReceiptDao
    abstract fun getDatabaseDao(): DatabaseDao
}