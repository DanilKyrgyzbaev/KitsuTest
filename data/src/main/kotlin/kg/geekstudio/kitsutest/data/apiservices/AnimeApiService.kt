package kg.geekstudio.kitsutest.data.apiservices

import model.AnimeModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET

interface AnimeApiService {
    @GET("anime")
    suspend fun getAnime(): Response<AnimeModel>

    companion object {
        operator fun invoke(retrofit: Retrofit) = retrofit.create<AnimeApiService>()
    }
}