package com.deliverhealth.assignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deliverhealth.assignment.model.StarWarCharacter
import com.deliverhealth.assignment.repository.MainRepository
import kotlinx.coroutines.*

class MainViewModel constructor(private val mainRepository: MainRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val starWarCharacterList = MutableLiveData<List<StarWarCharacter>>()
    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>()

    fun getAllMovies() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = mainRepository.getAllStarWarCharacters()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val apiResponse  = response.body()
                    starWarCharacterList.postValue(apiResponse?.starWarCharLists)
                    loading.value = false
                } else {
                    onError("Opps! Failed to fetch the data.")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}