package com.example.ciceronebottomnavigationsample.di

import com.example.ciceronebottomnavigationsample.navigation.LocalCiceroneHolder
import com.example.ciceronebottomnavigationsample.navigation.NavigationTabTags
import com.example.ciceronebottomnavigationsample.navigation.routers.ARouter
import com.example.ciceronebottomnavigationsample.navigation.routers.BRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.CRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.DRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.ILocalRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NavigationModule {

    @Singleton
    @Provides
    @ACicerone
    fun provideACicerone(ciceroneHolder: LocalCiceroneHolder): Cicerone<Router> {
        return ciceroneHolder.getCicerone(NavigationTabTags.TAG_A)
    }

    @Singleton
    @Provides
    @BCicerone
    fun provideBCicerone(ciceroneHolder: LocalCiceroneHolder): Cicerone<Router> {
        return ciceroneHolder.getCicerone(NavigationTabTags.TAG_B)
    }

    @Singleton
    @Provides
    @CCicerone
    fun provideCCicerone(ciceroneHolder: LocalCiceroneHolder): Cicerone<Router> {
        return ciceroneHolder.getCicerone(NavigationTabTags.TAG_C)
    }

    @Singleton
    @Provides
    @DCicerone
    fun provideDCicerone(ciceroneHolder: LocalCiceroneHolder): Cicerone<Router> {
        return ciceroneHolder.getCicerone(NavigationTabTags.TAG_D)
    }

    @Singleton
    @Provides
    fun provideARouter(@ACicerone cicerone: Cicerone<Router>): ARouter = ARouter(cicerone.router)

    @Singleton
    @Provides
    fun provideBRouter(@BCicerone cicerone: Cicerone<Router>): BRouter = BRouter(cicerone.router)

    @Singleton
    @Provides
    fun provideCRouter(@CCicerone cicerone: Cicerone<Router>): CRouter = CRouter(cicerone.router)

    @Singleton
    @Provides
    fun provideDRouter(@DCicerone cicerone: Cicerone<Router>): DRouter = DRouter(cicerone.router)

    @Singleton
    @Provides
    @ACicerone
    fun provideALocalRouter(aRouter: ARouter): ILocalRouter = aRouter

    @Singleton
    @Provides
    @BCicerone
    fun provideBLocalRouter(bRouter: BRouter): ILocalRouter = bRouter

    @Singleton
    @Provides
    @CCicerone
    fun provideCLocalRouter(cRouter: CRouter): ILocalRouter = cRouter

    @Singleton
    @Provides
    @DCicerone
    fun provideDLocalRouter(dRouter: DRouter): ILocalRouter = dRouter
}