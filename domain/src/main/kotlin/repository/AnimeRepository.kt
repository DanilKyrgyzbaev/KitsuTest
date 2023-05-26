package repository

import model.AnimeData
import util.ResultStatus

interface AnimeRepository {
    suspend fun getAnime(): ResultStatus<List<AnimeData>>
}