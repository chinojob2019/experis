package christian.loayza.retoexperis.data

import christian.loayza.retoexperis.data.database.dao.PlaceDao
import christian.loayza.retoexperis.data.database.entities.PlaceEntity
import christian.loayza.retoexperis.data.model.DetailsModel
import christian.loayza.retoexperis.data.model.PlaceModel
import christian.loayza.retoexperis.data.network.PlaceService
import christian.loayza.retoexperis.domain.model.Details
import christian.loayza.retoexperis.domain.model.Place
import christian.loayza.retoexperis.domain.model.toDomain
import javax.inject.Inject

class PlaceRepository @Inject constructor(
    private val placeDao: PlaceDao,
    private val api: PlaceService
) {


    suspend fun getAllPlaceFromApi():   List<Place> {
        val response: List<PlaceModel> = api.getAllPlaces()
        return response.map { it.toDomain() }
    }

    suspend fun getDetailsIdFromApi(id: String):  Details {
        val response: DetailsModel = api.getPlaceId(id)
        return response.toDomain()
    }

    suspend fun getAllPlacesFromDatabase():List<Place>{
        val response: List<PlaceEntity> = placeDao.getAllPlaces()
        return response.map { it.toDomain() }
    }

    suspend fun insertPlacesDatabase(places:List<PlaceEntity>){
     placeDao.insertAll(places)
    }

    suspend fun clearPlaces(){
        placeDao.deleteAllPlaces()
    }



}