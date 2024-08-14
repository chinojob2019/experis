package christian.loayza.retoexperis.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import christian.loayza.retoexperis.data.database.dao.PlaceDao
import christian.loayza.retoexperis.data.database.entities.PlaceEntity


@Database(entities = [PlaceEntity::class], version = 1, exportSchema = false)
abstract class PlaceDatabase : RoomDatabase() {
    abstract fun getPlaceDao(): PlaceDao
}