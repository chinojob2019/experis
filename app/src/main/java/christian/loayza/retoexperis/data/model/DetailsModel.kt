package christian.loayza.retoexperis.data.model

import com.google.gson.annotations.SerializedName

data class DetailsModel(

	@field:SerializedName("coordenaday")
	val coordenaday: String? = null,

	@field:SerializedName("coordenadax")
	val coordenadax: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("place")
	val place: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("info")
	val info: String? = null
)
