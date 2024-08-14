package christian.loayza.retoexperis.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import christian.loayza.retoexperis.data.database.entities.PlaceEntity
@Dao
interface PlaceDao {

    @Query("SELECT * FROM place_table ORDER BY id DESC")
    suspend fun getAllPlaces():List<PlaceEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(places:List<PlaceEntity>)

    @Query("DELETE FROM place_table")
    suspend fun deleteAllPlaces()


}