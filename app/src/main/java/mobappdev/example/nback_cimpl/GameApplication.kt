package mobappdev.example.nback_cimpl

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import mobappdev.example.nback_cimpl.model.data.UserPreferencesRepository
import mobappdev.example.nback_cimpl.model.data.SettingsRepository
/**
 * This is the Main Application
 *
 * Often your app doesn't even need this (custom) class, since the default
 * Application() class is enough. However, since we want to use DataStore for
 * saving the highscore, we create a custom version that inherits from the default
 * Application class.
 *
 *
 * Date: 25-08-2023
 * Version: Version 1.0
 * Author: Yeetivity
 *
 */

private const val APP_PREFERENCES_NAME = "game_preferences"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = APP_PREFERENCES_NAME
)

/*
* Custom app entry point for manual dependency injection
 */
class GameApplication: Application() {
    companion object {
        lateinit var instance: GameApplication
            private set
    }
    //todo använs för att spara highescore
    lateinit var userPreferencesRespository: UserPreferencesRepository
    lateinit var settingsRepository: SettingsRepository

    override fun onCreate() {
        super.onCreate()
        instance = this
        userPreferencesRespository = UserPreferencesRepository(dataStore)
        settingsRepository = SettingsRepository(dataStore)
    }
}