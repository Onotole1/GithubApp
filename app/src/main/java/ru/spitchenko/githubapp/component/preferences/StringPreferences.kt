package ru.spitchenko.githubapp.component.preferences

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun SharedPreferences.string(): ReadWriteProperty<Any, String?> = StringPreferencesDelegate(this)

private class StringPreferencesDelegate(
    private val preferences: SharedPreferences
) : ReadWriteProperty<Any, String?> {

    override fun getValue(thisRef: Any, property: KProperty<*>): String? =
        preferences.getString(property.name, null)

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String?) {
        preferences.edit {
            putString(property.name, value)
        }
    }
}