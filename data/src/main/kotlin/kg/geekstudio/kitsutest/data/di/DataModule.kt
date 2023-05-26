import com.squareup.moshi.Moshi
import kg.geekstudio.kitsutest.data.apiservices.AnimeApiService
import kg.geekstudio.kitsutest.data.remoteData.AnimeRepositoryImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import repository.AnimeRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.time.ExperimentalTime

private const val TIME_OUT = 30L
private const val BASE_URL = "https://kitsu.io/api/edge/"
@ExperimentalStdlibApi
@ExperimentalTime
val dataModule = module {
    single { createService(get()) }

    single { createRetrofit(get(), BASE_URL ) }

    single { createOkHttpClient() }

    single { MoshiConverterFactory.create() }

    single { Moshi.Builder().build() }

    single<AnimeRepository> { AnimeRepositoryImpl(apiService = get()) }

}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun createService(retrofit: Retrofit): AnimeApiService {
    return retrofit.create(AnimeApiService::class.java)
}