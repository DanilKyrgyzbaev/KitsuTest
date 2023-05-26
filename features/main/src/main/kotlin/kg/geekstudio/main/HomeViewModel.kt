package kg.geekstudio.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import base.BaseViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import model.AnimeData
import state.UIState
import useCase.GetAnimeUseCase
import util.ResultStatus

class HomeViewModel(private val getAnimeUseCase: GetAnimeUseCase) : BaseViewModel() {
    private val _animeList = MutableLiveData<UIState<List<AnimeData>>>()
    val animeList: LiveData<UIState<List<AnimeData>>> = _animeList

    fun fetchAnime() {
        viewModelScope.launch {
            val result = getAnimeUseCase()
            when (result) {
                is ResultStatus.Success -> {
                    val animeDataList = result.data ?: emptyList()
                    _animeList.value = UIState.Success(animeDataList)
                    Log.e("Success", "${result.data}")

                }
                is ResultStatus.Error -> {
                    _animeList.value = UIState.Error(result.message ?: "")
                    Log.e("Error", "${result.message}")
                }

                is ResultStatus.Loading -> {
                    // Обработка состояния загрузки
                }
            }
        }
    }
}