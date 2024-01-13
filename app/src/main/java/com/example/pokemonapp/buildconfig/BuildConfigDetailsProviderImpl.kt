package com.example.pokemonapp.buildconfig

import com.example.common.buildconfig.BuildConfigDetails
import com.example.common.buildconfig.BuildConfigDetailsProvider
import com.example.pokemonapp.BuildConfig
import javax.inject.Inject

class BuildConfigDetailsProviderImpl @Inject constructor() : BuildConfigDetailsProvider {
    override fun get(): BuildConfigDetails {
        return BuildConfigDetails(
            BuildConfig.BUILD_TYPE,
            BuildConfig.VERSION_CODE,
        )
    }
}