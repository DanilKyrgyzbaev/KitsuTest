package kg.geekstudio.kitsutest.data.model

import model.ImageMeta

data class AnimeImage(
    val tiny: String,
    val large: String,
    val small: String,
    val medium: String,
    val original: String,
    val meta: ImageMeta
)
