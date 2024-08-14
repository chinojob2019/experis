package christian.loayza.retoexperis.di

import android.content.Context
import androidx.room.Room
import christian.loayza.retoexperis.data.database.PlaceDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "experis_db"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, PlaceDatabase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun providePlaceDao(db: PlaceDatabase) = db.getPlaceDao()




}