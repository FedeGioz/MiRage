package com.federicogiordano.mirage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.federicogiordano.mirage.api.ApiServices
import com.federicogiordano.mirage.data.RobotStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StatusViewModel : ViewModel() {
    private val _status = MutableStateFlow<RobotStatus?>(null)
    val status: StateFlow<RobotStatus?> = _status.asStateFlow()

    init {
        startStatusPolling()
    }

    private fun startStatusPolling() {
        viewModelScope.launch {
            ApiServices.status.statusFlow().collect { status ->
                _status.value = status
            }
        }
    }

    fun refreshStatus() {
        viewModelScope.launch {
            _status.value = ApiServices.status.getStatus()
        }
    }
}