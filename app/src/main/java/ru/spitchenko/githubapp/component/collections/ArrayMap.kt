package ru.spitchenko.githubapp.component.collections

import androidx.collection.ArrayMap

fun <K, V> arrayMapOf(pairs: Array<out Pair<K, V>>): ArrayMap<K, V> {
    val map = ArrayMap<K, V>(pairs.size)
    for ((first, second) in pairs) {
        map[first] = second
    }
    return map
}