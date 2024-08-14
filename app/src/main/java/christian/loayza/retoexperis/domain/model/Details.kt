package christian.loayza.retoexperis.domain.model

import christian.loayza.retoexperis.data.model.DetailsModel
import com.google.gson.annotations.SerializedName


data class Details(
    val coordenaday: String? = null,
    val coordenadax: String? = null,
    val description: String? = null,
    val photo: String? = null,
    val place: String? = null,
    val title: String? = null,
    val info: String? = null
)
fun DetailsModel.toDomain() = Details(coordenaday, coordenadax, description, photo, place, title, info)


