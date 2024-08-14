package christian.loayza.retoexperis.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import christian.loayza.retoexperis.domain.model.Place
import com.google.gson.annotations.SerializedName


@Entity(tableName = "place_table")
data class PlaceEntity (@PrimaryKey(autoGenerate = true)
                        @ColumnInfo(name = "idem") val idem: Int? = 0,
                            @ColumnInfo(name = "id") val id: Int? = 1,
                            @ColumnInfo(name = "photo") val photo: String?,
                            @ColumnInfo(name = "description") val description: String?,
                            @ColumnInfo(name = "title") val title: String?)

fun Place.toDatabase() = PlaceEntity(photo = photo, description = description, title = title, id = id)


