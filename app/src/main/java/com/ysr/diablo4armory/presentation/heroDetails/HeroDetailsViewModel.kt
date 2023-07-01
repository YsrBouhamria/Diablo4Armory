package com.ysr.diablo4armory.presentation.heroDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ysr.diablo4armory.common.Constants
import com.ysr.diablo4armory.common.Resource
import com.ysr.diablo4armory.domain.usecase.getHero.GetHeroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HeroDetailsViewModel @Inject constructor(
    private val heroDetailsUseCase: GetHeroUseCase,
    private val savedStateHandle: SavedStateHandle
    ) : ViewModel() {

    private val _state = mutableStateOf(HeroDetailsState())
    val state : State<HeroDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_ACCOUNT_ID)?.let { accountId ->
            savedStateHandle.get<String>(Constants.PARAM_HERO_ID)?.let { heroId ->
                getHeroDetails(accountId, heroId)
            }
        }
    }
    private fun getHeroDetails(
        accountId: String,
        heroId: String
    ) {
        heroDetailsUseCase(
            accountId,
            heroId
        ).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = HeroDetailsState(
                        hero = result.data ?:
                        null)
                }
                is Resource.Loading -> {
                    _state.value = HeroDetailsState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = HeroDetailsState(error = result.message ?:
                    "Something went wrong"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}