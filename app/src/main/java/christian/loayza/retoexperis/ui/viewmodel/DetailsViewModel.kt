package christian.loayza.retoexperis.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import christian.loayza.retoexperis.domain.model.Details
import christian.loayza.retoexperis.domain.model.Place
import christian.loayza.retoexperis.domain.usecase.GetDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val getDetailsUseCase: GetDetailsUseCase): ViewModel() {


    val detailsModel = MutableLiveData<Details>()
    val isLoading = MutableLiveData<Boolean>()

    fun inicializar(id: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getDetailsUseCase(id)
                detailsModel.postValue(result)
                isLoading.postValue(false)
        }
    }




}