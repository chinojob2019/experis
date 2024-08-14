package christian.loayza.retoexperis.di

import christian.loayza.retoexperis.data.network.PlaceApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://experisreto-default-rtdb.firebaseio.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit):PlaceApiClient{
        return retrofit.create(PlaceApiClient::class.java)
    }




}