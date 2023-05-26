package model

data class AnimeData(
    val id: String,
    val type: String,
    val links: AnimeLinks,
    val attributes: AnimeAttributes,
    val relationships: AnimeRelationships
)
