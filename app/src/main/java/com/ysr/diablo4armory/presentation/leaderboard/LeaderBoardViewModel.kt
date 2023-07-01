package com.ysr.diablo4armory.presentation.leaderboard

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ysr.diablo4armory.common.Constants
import com.ysr.diablo4armory.common.Resource
import com.ysr.diablo4armory.domain.model.LeaderboardEntry
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
    var page = 1
    fun loadMore() {
        leaderBoardUseCase(
            "",
            "",
            "",
            Constants.LEADERBOARD_PAGE_SIZE,
            page
        ).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    result.data?.let {
                        _state.value.leaderBoardList.addAll(result.data)
                        page++
                    }
                }
                is Resource.Loading -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(error = result.message ?:
                    "Something went wrong"
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

}