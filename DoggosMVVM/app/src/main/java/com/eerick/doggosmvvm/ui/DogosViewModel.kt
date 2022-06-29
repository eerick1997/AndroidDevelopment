package com.eerick.doggosmvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eerick.doggosmvvm.domain.GetDogsUseCase
import com.eerick.doggosmvvm.domain.model.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogosViewModel @Inject constructor(
    private val getDogsUseCase: GetDogsUseCase
) : ViewModel() {
    val dogosModel = MutableLiveData<List<Dog>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        isLoading.postValue(true)
        viewModelScope.launch {
            val dogosList: List<Dog> = getDogsUseCase()
            if (!dogosList.isNullOrEmpty()) {
                dogosModel.postValue(dogosList)
                isLoading.postValue(false)
            }
        }
    }
}