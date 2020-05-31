import org.gradle.api.artifacts.dsl.DependencyHandler

private const val DEBUG_IMPLEMENTATION = "debugImplementation"
private const val IMPLEMENTATION = "implementation"
private const val KAPT = "kapt"
private const val TEST_IMPLEMENTATION = "testImplementation"
private const val ANDROID_TEST_IMPLEMENTATION = "androidTestImplementation"
private const val CLASSPATH_CONFIGURATION = "classpath"

fun DependencyHandler.leakCanary() {
    debugImplementation(Dependencies.Debug.LEAKCANARY_DEBUG)
}

fun DependencyHandler.androidxCore() {
    implementation(Dependencies.Main.Androidx.CORE)
}

fun DependencyHandler.appcompat() {
    implementation(Dependencies.Main.Androidx.APPCOMPAT)
}

fun DependencyHandler.material() {
    implementation(Dependencies.Main.Androidx.MATERIAL)
}

fun DependencyHandler.recyclerView() {
    implementation(Dependencies.Main.Androidx.RECYCLER_VIEW)
}

fun DependencyHandler.constraintLayout() {
    implementation(Dependencies.Main.Androidx.CONSTRAINT_LAYOUT)
}

fun DependencyHandler.swipeRefreshLayout() {
    implementation(Dependencies.Main.Androidx.SWIPE_REFRESH_LAYOUT)
}

fun DependencyHandler.playServicesAuth() {
    implementation(Dependencies.Main.PLAY_SERVICES_AUTH)
}

fun DependencyHandler.koin() {
    implementation(Dependencies.Main.KOIN.ANDROID)
    implementation(Dependencies.Main.KOIN.VIEW_MODEL)
}

fun DependencyHandler.room() {
    kapt(Dependencies.Main.Room.COMPILER)
    implementation(Dependencies.Main.Room.RUNTIME)
    implementation(Dependencies.Main.Room.COROUTINES)
}

fun DependencyHandler.navigation() {
    implementation(Dependencies.Main.Navigation.UI)
    implementation(Dependencies.Main.Navigation.FRAGMENT)
}

fun DependencyHandler.lifecycle() {
    kapt(Dependencies.Main.Lifecycle.COMPILER)
    implementation(Dependencies.Main.Lifecycle.EXTENSIONS)
    implementation(Dependencies.Main.Lifecycle.LIVE_DATA_KTX)
}

fun DependencyHandler.glide() {
    implementation(Dependencies.Main.Glide.GLIDE)
    kapt(Dependencies.Main.Glide.COMPILER)
}

fun DependencyHandler.okhttp() {
    implementation(Dependencies.Main.OkHttp.LOGGING)
    implementation(Dependencies.Main.OkHttp.URLCONNECTION)
    implementation(Dependencies.Main.OkHttp.OKHTTP)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.Main.Retrofit.RETROFIT)
    implementation(Dependencies.Main.Retrofit.SERIALIZATION_CONVERTER)
}

fun DependencyHandler.timber() {
    implementation(Dependencies.Main.TIMBER)
}

fun DependencyHandler.kotlin() {
    implementation(Dependencies.Main.Kotlin.STANDARD_LIBRARY)
}

fun DependencyHandler.kotlinSerializationRuntime() {
    implementation(Dependencies.Main.Kotlin.SERIALIZATION)
}

fun DependencyHandler.testing() {
    testImplementation(Dependencies.Test.JUNIT)
    testImplementation(Dependencies.Test.MOCKITO_KOTLIN)
    testImplementation(Dependencies.Test.TRUTH)
    testImplementation(Dependencies.Test.ANDROIDX_CORE_TESTING)
}

fun DependencyHandler.androidTesting() {
    androidTestImplementation(Dependencies.Test.JUNIT)
    androidTestImplementation(Dependencies.Test.SUPPORT_TEST_RULES)
    androidTestImplementation(Dependencies.Test.SUPPORT_TEST_RUNNER)
    androidTestImplementation(Dependencies.Test.ROOM)
    androidTestImplementation(Dependencies.Test.ANDROIDX_CORE_TESTING)
    androidTestImplementation(Dependencies.Test.KOIN_TESTING)
}

fun DependencyHandler.coroutines() {
    implementation(Dependencies.Main.Coroutines.COROUTINES)
    implementation(Dependencies.Main.Coroutines.COROUTINES_ANDROID)
    implementation(Dependencies.Main.Coroutines.PLAY_SERVICES)
}

fun DependencyHandler.androidGradlePlugin() {
    classpath(Dependencies.Build.ANDROID_GRADLE_PLUGIN)
}

fun DependencyHandler.kotlinGradlePlugin() {
    classpath(Dependencies.Build.KOTLIN_GRADLE_PLUGIN)
}

fun DependencyHandler.googleServices() {
    classpath(Dependencies.Build.GOOGLE_SERVICES)
}

fun DependencyHandler.kotlinSerialization() {
    classpath(Dependencies.Build.SERIALIZATION)
}

private fun DependencyHandler.classpath(dependency: String) {
    add(CLASSPATH_CONFIGURATION, dependency)
}

private fun DependencyHandler.implementation(dependency: String) {
    add(IMPLEMENTATION, dependency)
}

private fun DependencyHandler.testImplementation(dependency: String) {
    add(TEST_IMPLEMENTATION, dependency)
}

private fun DependencyHandler.androidTestImplementation(dependency: String) {
    add(ANDROID_TEST_IMPLEMENTATION, dependency)
}

private fun DependencyHandler.debugImplementation(dependency: String) {
    add(DEBUG_IMPLEMENTATION, dependency)
}

private fun DependencyHandler.kapt(dependency: String) {
    add(KAPT, dependency)
}