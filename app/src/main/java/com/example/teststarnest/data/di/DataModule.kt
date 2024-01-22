package com.example.teststarnest.data.di

import com.example.teststarnest.data.repository.keyboard.*
import com.example.teststarnest.data.repository.keyboardcategory.*
import dagger.*
import dagger.hilt.*
import dagger.hilt.components.*

/**
 * Created by tuyen.dang on 1/22/2024.
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    internal abstract fun bindKeyBoardRepository(
        keyBoardRepository: KeyBoardRepositoryImpl
    ): KeyBoardRepository

    @Binds
    internal abstract fun bindKeyBoardCategoryRepository(
        keyBoardCategoryRepository: KeyBoardCategoryRepositoryImpl
    ): KeyBoardCategoryRepository
}
