package christian.loayza.retoexperis.data.model

import com.google.gson.annotations.SerializedName


data class PlaceModel(
	@SerializedName("description") val description: String,
	@SerializedName("photo") val photo: String,
	@SerializedName("id") val id: Int,
	@SerializedName("title") val title: String
)

