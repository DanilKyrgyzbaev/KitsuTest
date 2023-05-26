package kg.geekstudio.kitsutest.data.model

import model.AnimeImage
import model.AnimeTitles

data class AnimeAttributes(
    val createdAt: String,
    val updatedAt: String,
    val slug: String,
    val synopsis: String,
    val description: String,
    val coverImageTopOffset: Int,
    val titles: AnimeTitles,
    val canonicalTitle: String,
    val abbreviatedTitles: List<String>,
    val averageRating: String,
    val ratingFrequencies: Map<String, String>,
    val userCount: Int,
    val favoritesCount: Int,
    val startDate: String,
    val endDate: String,
    val nextRelease: String?,
    val popularityRank: Int,
    val ratingRank: Int,
    val ageRating: String,
    val ageRatingGuide: String,
    val subtype: String,
    val status: String,
    val tba: String?,
    val posterImage: AnimeImage,
    val coverImage: AnimeImage,
    val episodeCount: Int,
    val episodeLength: Int,
    val totalLength: Int,
    val youtubeVideoId: String,
    val showType: String,
    val nsfw: Boolean
)
