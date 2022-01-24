import extensions.applyAndroidDefault
import extensions.arrow
import extensions.commonBaseDependencies
import extensions.defaultBuildConfigField
import extensions.implementationProject
import extensions.testingCommon
import org.gradle.kotlin.dsl.android
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.implementation
import org.gradle.kotlin.dsl.testImplementation

plugins {
    id(GradlePlugins.androidLibrary)
    id(GradlePlugins.kotlinAndroid)
    id(GradlePlugins.kotlinAndroidExtensions)
    id(GradlePlugins.kotlinKapt)
}

android {
    applyAndroidDefault()

    defaultBuildConfigField("BASE_URL", BASE_URL)
}

dependencies {
    commonBaseDependencies()

    implementationProject(Modules.sharedInterfaces)

    arrow()

    //    Retrofit 2
    implementation(Libraries.retrofit)
    implementation(Libraries.retrofitInterceptor)

    implementation(Libraries.kotlinSerialization)
    implementation(Libraries.kotlinSerializationConverter)

    // Koin
    implementation(Libraries.koinAndroid)

    // Logger
    implementation(Libraries.logger)

    testingCommon()
    testImplementation(TestLibraries.koTestArrow)
    testImplementation(TestLibraries.retrofitMockWebServer)
    testImplementation(TestLibraries.guava)
}
