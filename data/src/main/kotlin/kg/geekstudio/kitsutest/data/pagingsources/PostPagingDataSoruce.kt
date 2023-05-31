package kg.geekstudio.kitsutest.data.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kg.geekstudio.kitsutest.data.apiservices.AnimeApiService
import model.anime.AnimeData

 class PostPagingDataSoruce(private val apiService: AnimeApiService) : PagingSource<Int, AnimeData>() {

    override fun getRefreshKey(state: PagingState<Int, AnimeData>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AnimeData> {
        return try {
            val page = params.key ?: 1
            val limit = 20
            val response = apiService.getAnime(page, limit)
            if (response.isSuccessful) {
                val animeResponse = response.body()?.data ?: emptyList()
                val nextKey = if (animeResponse.isEmpty()) null else page + 1
                val prevKey = if (page == 1) null else page - 1

                LoadResult.Page(
                    data = animeResponse,
                    prevKey = prevKey,
                    nextKey = nextKey
                )
            } else {
                LoadResult.Error(Exception("Не удалось получить данные об аниме."))
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}