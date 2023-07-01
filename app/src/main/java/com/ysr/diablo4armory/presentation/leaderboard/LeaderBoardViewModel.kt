package com.ysr.diablo4armory.presentation.leaderboard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ysr.diablo4armory.common.Constants
import com.ysr.diablo4armory.common.Resource
import com.ysr.diablo4armory.domain.usecase.getleaderboard.GetLeaderBoardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LeaderBoardViewModel @Inject constructor(
    private val leaderBoardUseCase: GetLeaderBoardUseCase,
    private val savedStateHandle: SavedStateHandle
    ) : ViewModel() {

    private val _state = mutableStateOf(LeaderBoardState())
    val state : State<LeaderBoardState> = _state

    init {

        getLeaderBoard(
            savedStateHandle.get<String>(Constants.PARAM_CLASS_FILTER),
            savedStateHandle.get<String>(Constants.PARAM_MODE_FILTER),
            savedStateHandle.get<String>(Constants.PARAM_ORDER_BY),
            Constants.LEADERBOARD_PAGE_SIZE,
            savedStateHandle.get<String>(Constants.CURRENT_PAGE)
        )
    }
    private fun getLeaderBoard(playerClass: String?, mode: String?, rank: String?, pageSize: String?, pageNumber: String?) {
        leaderBoardUseCase(
            playerClass,
            mode,
            rank,
            pageSize,
            pageNumber
        ).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = LeaderBoardState(
                        leaderBoardList = result.data ?:
                        emptyList())
                }
                is Resource.Loading -> {
                    _state.value = LeaderBoardState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = LeaderBoardState(error = result.message ?:
                    "Something went wrong"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}