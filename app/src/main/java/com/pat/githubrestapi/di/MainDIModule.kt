package com.pat.githubrestapi

import com.pat.githubrestapi.interfaces.GitHubApiInterface
import com.pat.githubrestapi.viewmodel.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    viewModel { MainViewModel(get()) }
    single<ApiInterface> { GitHubInterfaceImpl() }


}