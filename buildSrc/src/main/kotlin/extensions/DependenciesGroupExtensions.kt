package extensions

import Libraries
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
    implementation(Libraries.constraintLayout)
}

fun DependencyHandlerScope.arrow() {
    implementation(Libraries.arrowCore)
    implementation(Libraries.arrowSyntax)
    kapt(Libraries.arrowMeta)
}

fun DependencyHandlerScope.lifecycle() {
    implementation(Libraries.lifecycleViewModel)
    implementation(Libraries.lifecycleLiveData)
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
    implementation(Libraries.koinFragment)
    implementation(Libraries.koinExperimental)
}

fun DependencyHandlerScope.testingCommon() {
    testImplementation(TestLibraries.junit)
    testImplementation(TestLibraries.mockk)
    testImplementation(TestLibraries.koTestRunner)
    testImplementation(TestLibraries.koTestAssertionsCore)
    testImplementation(TestLibraries.koTestProperty)
    testImplementation(TestLibraries.koTestArrow)
}

fun DependencyHandlerScope.featureBaseDependencies() {
    androidSupport()
    arrow()
    lifecycle()
    coroutines()
    koin()
    testingCommon()
}