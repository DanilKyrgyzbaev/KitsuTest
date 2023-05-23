package kg.geekstudio.main

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

@ExperimentalCoroutinesApi
val mainModule = module {
    viewModelOf(::HomeViewModel)
}