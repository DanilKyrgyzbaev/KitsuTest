package kg.geekstudio.kitsutest

import android.app.Application
import dataModule
import domainModule
import kg.geekstudio.main.mainModule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    domainModule,
                    dataModule,
                    mainModule
                )
            )
        }
    }
}