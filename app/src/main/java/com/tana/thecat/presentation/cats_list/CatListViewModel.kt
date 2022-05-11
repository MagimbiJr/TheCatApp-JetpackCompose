package com.tana.thecat.presentation.cats_list

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tana.thecat.repository.TheCatRepository
import com.tana.thecat.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatListViewModel @Inject constructor(
    private val repository: TheCatRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(CatListUiState())
    val uiState = _uiState.asStateFlow()
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()
    val searchBarVisible = mutableStateOf(false)

    init {
        loadBreeds()
    }

    private fun loadBreeds() {
        repository.getCatBreeds().onEach { response ->
            when (response) {
                is Resource.Success -> {

                    _uiState.value = CatListUiState(catsList = response.data ?: emptyList())
                }
                is Resource.Failure -> {
                    _uiState.value =
                        CatListUiState(message = response.message ?: "An unknown error occurred")
                }
                is Resource.Loading -> {
                    _uiState.value = CatListUiState(loading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun searchTextChange(text: String) {
        _searchText.value = text
    }

}