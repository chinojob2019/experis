package christian.loayza.retoexperis.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import christian.loayza.retoexperis.domain.model.Place
import christian.loayza.retoexperis.domain.usecase.GetPlaceUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPlaceUseCase: GetPlaceUseCase
) : ViewModel() {

    val placeModel = MutableLiveData<List<Place>>()
    val isLoading = MutableLiveData<Boolean>()

    fun inicializar() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPlaceUseCase()
            if (!result.isNullOrEmpty()) {
                placeModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }


}