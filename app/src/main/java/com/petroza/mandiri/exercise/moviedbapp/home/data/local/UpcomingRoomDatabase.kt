package com.petroza.mandiri.exercise.moviedbapp.home.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.petroza.mandiri.exercise.moviedbapp.home.data.local.dao.PopularDao
import com.petroza.mandiri.exercise.moviedbapp.home.data.local.dao.UpcomingDao
import com.petroza.mandiri.exercise.moviedbapp.home.data.local.entity.Movies

@Database(entities = [Movies::class], version = 1)
abstract class UpcomingRoomDatabase: RoomDatabase() {

    abstract fun upcomingDao(): UpcomingDao

    companion object {
        @Volatile
        private var INSTANCE: UpcomingRoomDatabase ?= null

        fun getDatabase(context: Context): UpcomingRoomDatabase {
            val tmpInstance = INSTANCE

            if ( tmpInstance != null ) {
                return tmpInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        UpcomingRoomDatabase::class.java,
                        "upcoming_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                return instance
            }
        }
    }

}