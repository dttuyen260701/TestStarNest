package com.example.teststarnest.data.di

import android.content.Context
import androidx.room.*
import com.example.teststarnest.data.database.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideKeyBoardDB(@ApplicationContext context: Context): KeyBoardDatabase =
        Room.databaseBuilder(context, KeyBoardDatabase::class.java, "keyboard").build()

    @Provides
    fun provideKeyBoardDao(appDB: KeyBoardDatabase) = appDB.keyBoardDao()

    @Provides
    fun provideKeyBoardCategoryDao(appDB: KeyBoardDatabase) = appDB.KeyBoardCategoryDao()
}
