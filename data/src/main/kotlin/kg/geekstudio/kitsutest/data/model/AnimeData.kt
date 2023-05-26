package kg.geekstudio.kitsutest.data.model

import model.AnimeLinks
import model.AnimeRelationships

data class AnimeData(
    val id: String,
    val type: String,
    val links: AnimeLinks,
    val attributes: AnimeAttributes,
    val relationships: AnimeRelationships
)
