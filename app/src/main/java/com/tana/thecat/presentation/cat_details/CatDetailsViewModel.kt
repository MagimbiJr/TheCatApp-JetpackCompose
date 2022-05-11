package com.tana.thecat.presentation.cat_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tana.thecat.repository.TheCatRepository
import com.tana.thecat.utils.Constants.PARAM_BREED_ID
import com.tana.thecat.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CatDetailsViewModel @Inject constructor(
    private val repository: TheCatRepository,
    stateHandle: SavedStateHandle
) : ViewModel(){
    private val _uiState = MutableStateFlow(CatDetailsUiState())
    val uiState = _uiState.asStateFlow()


}