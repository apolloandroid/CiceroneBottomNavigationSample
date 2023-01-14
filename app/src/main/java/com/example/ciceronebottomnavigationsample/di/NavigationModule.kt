package com.example.ciceronebottomnavigationsample.di

import com.example.ciceronebottomnavigationsample.navigation.LocalCiceroneHolder
import com.example.ciceronebottomnavigationsample.navigation.TabTags
import com.example.ciceronebottomnavigationsample.navigation.routers.ARouter
import com.example.ciceronebottomnavigationsample.navigation.routers.BRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.CRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.IARouter
import com.example.ciceronebottomnavigationsample.navigation.routers.IBRouter
import com.example.ciceronebottomnavigationsample.navigation.routers.ICRouter
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
        return ciceroneHolder.getCicerone(TabTags.TAG_A)
    }

    @Singleton
    @Provides
    @BCicerone
    fun provideBCicerone(ciceroneHolder: LocalCiceroneHolder): Cicerone<Router> {
        return ciceroneHolder.getCicerone(TabTags.TAG_B)
    }

    @Singleton
    @Provides
    @CCicerone
    fun provideCCicerone(ciceroneHolder: LocalCiceroneHolder): Cicerone<Router> {
        return ciceroneHolder.getCicerone(TabTags.TAG_C)
    }

    @Singleton
    @Provides
    @ALocalRouter
    fun provideALocalRouter(aRouter: IARouter): ILocalRouter = aRouter

    @Singleton
    @Provides
    @BLocalRouter
    fun provideBLocalRouter(bRouter: IBRouter): ILocalRouter = bRouter

    @Singleton
    @Provides
    @CLocalRouter
    fun provideCLocalRouter(cRouter: ICRouter): ILocalRouter = cRouter

    @Singleton
    @Provides
    fun provideARouter(@ACicerone cicerone: Cicerone<Router>): IARouter = ARouter(cicerone.router)

    @Singleton
    @Provides
    fun provideBRouter(@BCicerone cicerone: Cicerone<Router>): IBRouter = BRouter(cicerone.router)

    @Singleton
    @Provides
    fun provideCRouter(@CCicerone cicerone: Cicerone<Router>): ICRouter = CRouter(cicerone.router)
}