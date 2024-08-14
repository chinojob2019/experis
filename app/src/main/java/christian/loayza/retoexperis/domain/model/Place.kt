package christian.loayza.retoexperis.domain.model

import christian.loayza.retoexperis.data.database.entities.PlaceEntity
import christian.loayza.retoexperis.data.model.PlaceModel
import com.google.gson.annotations.SerializedName

data class Place(
    val description: String? = null,
    val photo: String? = null,
    val id: Int? = null,
    val title: String? = null
)

fun PlaceModel.toDomain() = Place(description,photo,id ,title)
fun PlaceEntity.toDomain() = Place(description,photo,id ,title)