package com.example.practicingcleanarch2.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicingcleanarch2.domain.use_cases.GetDogs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDogs: GetDogs
) : ViewModel() {
    val dogsLiveData = MutableLiveData<List<String>>()

    fun getDogsList() {
        viewModelScope.launch {
            val dogsList = getDogs()
            if (dogsList.isNotEmpty()) {
                dogsLiveData.postValue(dogsList)
            }
        }
    }
}