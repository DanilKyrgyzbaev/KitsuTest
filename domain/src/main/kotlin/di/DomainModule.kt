import org.koin.dsl.module
import useCase.GetAnimeUseCase

val domainModule = module {
    factory { GetAnimeUseCase(get()) }

}