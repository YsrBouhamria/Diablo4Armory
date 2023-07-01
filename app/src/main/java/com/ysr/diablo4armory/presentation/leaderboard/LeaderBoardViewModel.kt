package com.ysr.diablo4armory.presentation.leaderboard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ysr.diablo4armory.common.Resource
import com.ysr.diablo4armory.domain.usecase.getleaderboard.GetLeaderBoardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LeaderBoardViewModel @Inject constructor(
    private val leaderBoardUseCase: GetLeaderBoardUseCase
    ) : ViewModel() {

    private val _state = mutableStateOf(LeaderBoardState())
    val state : State<LeaderBoardState> = _state

    init {
        getLeaderBoard()
    }
    private fun getLeaderBoard() {
        leaderBoardUseCase(
            null,
            null,
            null,
            null,
            null
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