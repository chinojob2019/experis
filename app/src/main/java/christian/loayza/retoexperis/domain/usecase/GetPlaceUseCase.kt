package christian.loayza.retoexperis.domain.usecase

import christian.loayza.retoexperis.data.PlaceRepository
import christian.loayza.retoexperis.data.database.entities.toDatabase
import christian.loayza.retoexperis.domain.model.Place
import javax.inject.Inject

class GetPlaceUseCase @Inject constructor(private val placeRepository: PlaceRepository) {
    suspend operator fun invoke(): List<Place> {
        val places = placeRepository.getAllPlaceFromApi()
        return if (places.isNotEmpty()) {
            placeRepository.clearPlaces()
            placeRepository.insertPlacesDatabase(places.map { it.toDatabase() })
            places
        } else {
            placeRepository.getAllPlacesFromDatabase()
        }
    }
}