import Secrets.BASE_URL
import extensions.applyAndroidDefault
import extensions.arrow
import extensions.commonBaseDependencies
import extensions.defaultBuildConfigField
import extensions.implementationProject
import extensions.testingCommon

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
    implementation(Libraries.retrofitMoshiConverter)
    implementation(Libraries.retrofitInterceptor)

    implementation(Libraries.moshi)

    // Koin
    implementation(Libraries.koinAndroid)

    // Logger
    implementation(Libraries.logger)

    testingCommon()
    testImplementation(TestLibraries.koTestArrow)
    testImplementation(TestLibraries.retrofitMockWebServer)
    testImplementation(TestLibraries.guava)
}
