package com.example.practicingcleanarch.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicingcleanarch.domain.use_case.GetDogs
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDogs: GetDogs
) : ViewModel() {

    val dogsList = MutableLiveData<List<String>>()

    fun getAllDogs() {
        viewModelScope.launch {
            val dogsData = getDogs()
            dogsList.postValue(dogsData)
        }
    }

}