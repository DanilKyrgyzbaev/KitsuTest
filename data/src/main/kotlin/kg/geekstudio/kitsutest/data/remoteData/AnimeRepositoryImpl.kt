package kg.geekstudio.kitsutest.data.remoteData

import kg.geekstudio.kitsutest.data.apiservices.AnimeApiService
import model.AnimeData
import repository.AnimeRepository
import util.ResultStatus

class AnimeRepositoryImpl(private val apiService: AnimeApiService) : AnimeRepository {

    override suspend fun getAnime(): ResultStatus<List<AnimeData>> {
        return try {
            val response = apiService.getAnime()
            if (response.isSuccessful) {
                val animeResponse = response.body()
                animeResponse?.data?.let {
                    ResultStatus.Success(it)
                } ?: ResultStatus.Error(null, "Пустые данные ответа")
            } else {
                ResultStatus.Error(null, "Не удалось получить данные об аниме.")
            }
        } catch (e: Exception) {
            ResultStatus.Error(null, e.message)
        }
    }
}