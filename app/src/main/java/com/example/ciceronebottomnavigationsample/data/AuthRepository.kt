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
    private val KEY_AUTHENTICATED = booleanPreferencesKey("key_authenticated")

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(PREFERENCES_NAME)

    val isAuthenticated: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[KEY_AUTHENTICATED] ?: false
    }


    suspend fun setAuthenticated(authenticated: Boolean) = context.dataStore.edit { preferences ->
        preferences[KEY_AUTHENTICATED] = authenticated
    }
}