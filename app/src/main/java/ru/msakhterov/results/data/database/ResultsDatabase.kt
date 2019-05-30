package ru.msakhterov.results.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import ru.msakhterov.results.data.database.dao.ActivityDao
import ru.msakhterov.results.data.database.dao.ResultDao
import ru.msakhterov.results.data.entities.Activity
import ru.msakhterov.results.data.entities.Result

@Database(entities = [Activity::class, Result::class], version = 1, exportSchema = false)
abstract class ResultsDatabase : RoomDatabase() {

    abstract val activityDao: ActivityDao
    abstract val resultDao: ResultDao

    companion object {
        const val dbName = "result_db"
        @Volatile
        private var INSTANCE: ResultsDatabase? = null

        fun getDatabase(context: Context): ResultsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ResultsDatabase::class.java,
                    dbName
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
