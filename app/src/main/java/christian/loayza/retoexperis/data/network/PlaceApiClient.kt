package christian.loayza.retoexperis.data.network

import christian.loayza.retoexperis.data.model.DetailsModel
import christian.loayza.retoexperis.data.model.PlaceModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PlaceApiClient {
    @GET("/Lugares/.json")
    suspend fun getAllPlaces(): Response<ArrayList<PlaceModel>>

    @GET("/LugaresDetalle/{id}/.json")
    suspend fun getPlaceId(@Path("id")id: String): Response<DetailsModel>


}