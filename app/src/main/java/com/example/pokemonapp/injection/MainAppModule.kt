package com.example.pokemonapp.injection

import com.example.common.buildconfig.BuildConfigDetailsProvider
import com.example.pokemonapp.buildconfig.BuildConfigDetailsProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainAppModule {

    @Provides
    @Singleton
    fun provideBuildConfigDetailsProvider(
        buildConfigDetailsProvider : BuildConfigDetailsProviderImpl
    ): BuildConfigDetailsProvider {
        return buildConfigDetailsProvider
    }
}