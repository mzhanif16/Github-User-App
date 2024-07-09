package com.mzhnf.core.data.di

import com.mzhnf.core.data.repository.RepositoryImpl
import com.mzhnf.core.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {
    @Binds
    fun bindRepository(repository: RepositoryImpl): Repository
}