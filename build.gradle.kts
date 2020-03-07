buildscript {
    mainRepositories()

    dependencies {
        androidGradlePlugin()
        googleServices()
        kotlinGradlePlugin()
        kotlinSerialization()
    }
}

allprojects {
    mainRepositories()
}