object Modules {

    val all: Set<String>
        get() = mobileFeatures + setOf(
            mobileApp
        )

    val mobileFeatures: Set<String>
        get() = setOf()

    // App
    const val mobileApp = ":app"
}