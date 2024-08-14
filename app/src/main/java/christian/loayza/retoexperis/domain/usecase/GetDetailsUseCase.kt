package christian.loayza.retoexperis.domain.usecase

import christian.loayza.retoexperis.data.PlaceRepository
import christian.loayza.retoexperis.domain.model.Details
import christian.loayza.retoexperis.domain.model.Place
import javax.inject.Inject

class GetDetailsUseCase @Inject constructor(private val placeRepository: PlaceRepository) {

    suspend operator fun invoke(id: String): Details
    {
      return  placeRepository.getDetailsIdFromApi(id)
    }

}