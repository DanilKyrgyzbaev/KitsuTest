package model

data class AnimeRelationships(
    val genres: RelationshipLinks,
    val categories: RelationshipLinks,
    val castings: RelationshipLinks,
    val installments: RelationshipLinks,
    val mappings: RelationshipLinks,
    val reviews: RelationshipLinks,
    val mediaRelationships: RelationshipLinks,
    val characters: RelationshipLinks,
    val staff: RelationshipLinks,
    val productions: RelationshipLinks,
    val quotes: RelationshipLinks,
    val episodes: RelationshipLinks,
    val streamingLinks: RelationshipLinks,
    val animeProductions: RelationshipLinks,
    val animeCharacters: RelationshipLinks,
    val animeStaff: RelationshipLinks
)
