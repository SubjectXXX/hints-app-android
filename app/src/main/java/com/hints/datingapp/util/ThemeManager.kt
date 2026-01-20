package com.hints.datingapp.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class ThemeManager(private val context: Context) {
    
    companion object {
        private val IS_NIGHT_MODE = booleanPreferencesKey("is_night_mode")
    }
    
    val isNightMode: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[IS_NIGHT_MODE] ?: false
        }
    
    suspend fun setNightMode(isNightMode: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_NIGHT_MODE] = isNightMode
        }
    }
    
    suspend fun toggleTheme() {
        context.dataStore.edit { preferences ->
            val current = preferences[IS_NIGHT_MODE] ?: false
            preferences[IS_NIGHT_MODE] = !current
        }
    }
}
