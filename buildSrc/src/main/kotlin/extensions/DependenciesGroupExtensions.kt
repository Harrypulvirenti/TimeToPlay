package extensions

import Libraries
import Modules
import TestLibraries
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies

fun Project.commonBaseDependencies() {
    dependencies {
        implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
        implementation(Libraries.kotlinStdlib)
    }
}

fun DependencyHandlerScope.androidSupport() {
    implementation(Libraries.appCompat)
    implementation(Libraries.fragment)
    implementation(Libraries.constraintLayout)
}

fun DependencyHandlerScope.arrow() {
    implementation(Libraries.arrowCore)
    implementation(Libraries.arrowSyntax)
    kapt(Libraries.arrowMeta)
}

fun DependencyHandlerScope.lifecycle() {
    implementation(Libraries.lifecycleViewModel)
    implementation(Libraries.lifecycleRuntime)
    implementation(Libraries.lifecycleSavedState)
    kapt(Libraries.lifecycleCompiler)
}

fun DependencyHandlerScope.coroutines() {
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinesAndroid)
}

fun DependencyHandlerScope.koin() {
    implementation(Libraries.koinAndroid)
    implementation(Libraries.koinScope)
    implementation(Libraries.koinViewModel)
    implementation(Libraries.koinExperimental)
}

fun DependencyHandlerScope.moshi() {
    implementation(Libraries.moshi)
    kapt(Libraries.moshiCodegen)
}

fun DependencyHandlerScope.testingCommon() {
    testImplementation(TestLibraries.junit)
    testImplementation(TestLibraries.mockk)
    testImplementation(TestLibraries.koTestRunner)
    testImplementation(TestLibraries.koTestAssertionsCore)
    testImplementation(TestLibraries.koTestProperty)
}

fun DependencyHandlerScope.featureBaseDependencies() {

    implementationProject(
        Modules.kotlinExtensions,
        Modules.androidExtensions,
        Modules.sharedInterfaces,
        Modules.core,
        Modules.navigation
    )


    androidSupport()
    lifecycle()
    koin()
    coroutines()

    testImplementationProject(Modules.testImplementation)
    testingCommon()
    testImplementation(TestLibraries.lifecycleTest)
    testImplementation(TestLibraries.flowTesting)
}