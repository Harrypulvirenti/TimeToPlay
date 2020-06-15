import extensions.applyAndroidDefault
import extensions.commonBaseDependencies
import extensions.coroutines
import extensions.implementationProject

plugins {
    id(GradlePlugins.androidLibrary)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinAndroidExtensions)
}

applyAndroidDefault()

dependencies {
    commonBaseDependencies()

    implementationProject(
        Modules.sharedInterfaces,
        Modules.androidExtensions
    )

    implementation(Libraries.appCompat)
    implementation(Libraries.fragment)

    // Coroutine
    coroutines()

    // Koin
    implementation(Libraries.koinAndroid)

    // Logger
    implementation(Libraries.logger)
}
