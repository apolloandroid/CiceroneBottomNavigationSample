package com.example.ciceronebottomnavigationsample.di

import com.example.ciceronebottomnavigationsample.navigation.LocalCiceroneHolder
import com.example.ciceronebottomnavigationsample.navigation.NavigationTabTags
import com.example.ciceronebottomnavigationsample.navigation.routers.ARouter
import com.example.ciceronebottomnavigationsample.navigation.routers.BRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.CRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.DRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.IARouter
import com.example.ciceronebottomnavigationsample.navigation.routers.IBRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.ICRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.IDRouter
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
    fun provideARouter(@ACicerone cicerone: Cicerone<Router>): IARouter = ARouter(cicerone.router)

    @Singleton
    @Provides
    fun provideBRouter(@BCicerone cicerone: Cicerone<Router>): IBRouter = BRouter(cicerone.router)

    @Singleton
    @Provides
    fun provideCRouter(@CCicerone cicerone: Cicerone<Router>): ICRouter = CRouter(cicerone.router)

    @Singleton
    @Provides
    fun provideDRouter(@DCicerone cicerone: Cicerone<Router>): IDRouter = DRouter(cicerone.router)

    @Singleton
    @Provides
    @ACicerone
    fun provideALocalRouter(aRouter: IARouter): ILocalRouter = aRouter

    @Singleton
    @Provides
    @BCicerone
    fun provideBLocalRouter(bRouter: IBRouter): ILocalRouter = bRouter

    @Singleton
    @Provides
    @CCicerone
    fun provideCLocalRouter(cRouter: ICRouter): ILocalRouter = cRouter

    @Singleton
    @Provides
    @DCicerone
    fun provideDLocalRouter(dRouter: IDRouter): ILocalRouter = dRouter
}