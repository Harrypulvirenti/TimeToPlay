import extensions.applyAndroidDefault
import extensions.commonBaseDependencies
import extensions.implementationProject
import extensions.navigation

plugins {
    id(GradlePlugins.androidLibrary)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinAndroidExtensions)
}

applyAndroidDefault()

dependencies {
    commonBaseDependencies()

    implementationProject(
        Modules.core,
        Modules.navigation
    )

    implementation(Libraries.appCompat)

    navigation()
}
