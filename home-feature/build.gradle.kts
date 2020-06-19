import extensions.applyAndroidDefault
import extensions.arrow
import extensions.commonBaseDependencies
import extensions.featureBaseDependencies
import extensions.implementationProject

plugins {
    id(GradlePlugins.androidLibrary)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinAndroidExtensions)
    id(GradlePlugins.kotlinKapt)
}

applyAndroidDefault()

dependencies {
    commonBaseDependencies()
    featureBaseDependencies()

    implementation(Libraries.viewPager)
    implementation(Libraries.coilImageLoader)

    // Arrow
    arrow()

    implementationProject(
        Modules.dataSources,
        Modules.entities
    )
}
