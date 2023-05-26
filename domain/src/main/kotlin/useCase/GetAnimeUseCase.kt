package useCase

import model.AnimeData
import repository.AnimeRepository
import util.ResultStatus

class GetAnimeUseCase (private val animeRepository: AnimeRepository) {
    suspend operator fun invoke(): ResultStatus<List<AnimeData>> {
        return animeRepository.getAnime()
    }
}