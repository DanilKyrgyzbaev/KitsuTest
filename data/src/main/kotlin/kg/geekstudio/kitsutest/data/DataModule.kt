import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.dsl.module
import kotlin.time.ExperimentalTime

@ExperimentalStdlibApi
@ExperimentalTime
@ExperimentalCoroutinesApi
val dataModule = module {
//    single { ApiService(retrofit = get(named("WithoutAuth"))) }
}