package christian.loayza.retoexperis.data.network

import christian.loayza.retoexperis.data.model.DetailsModel
import christian.loayza.retoexperis.data.model.PlaceModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlaceService @Inject constructor(private val api: PlaceApiClient){


    suspend fun getAllPlaces(): List<PlaceModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllPlaces()
            response.body() ?: emptyList()
        }
    }

    suspend fun getPlaceId(id: String): DetailsModel{
        return withContext(Dispatchers.IO){
            val response = api.getPlaceId(id)
            response.body()!!
        }
    }


}