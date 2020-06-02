package com.mihudev.dogs.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.mihudev.dogs.model.DogBreed
import com.mihudev.dogs.model.DogDatabase
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : BaseViewModel(application) {

    val dogLiveData = MutableLiveData<DogBreed>()

    fun fetch(dogUuid: Int) {
        launch {
            val dog = DogDatabase(getApplication()).dogDao().getDog(dogUuid)
            dogLiveData.value = dog
        }
    }
}