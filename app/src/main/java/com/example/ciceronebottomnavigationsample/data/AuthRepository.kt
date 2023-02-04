package com.example.ciceronebottomnavigationsample.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    @ApplicationContext
    private val context: Context
) {

    private val PREFERENCES_NAME = "preferences"
    private val KEY_LOGGED_IN = booleanPreferencesKey("key_logged_in")

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(PREFERENCES_NAME)

    val loggedIn: Flow<Boolean> = context.dataStore.data.map { it[KEY_LOGGED_IN] ?: false }

    suspend fun logIn() = context.dataStore.edit { it[KEY_LOGGED_IN] = true }

    suspend fun logOut() = context.dataStore.edit { it[KEY_LOGGED_IN] = false }
}