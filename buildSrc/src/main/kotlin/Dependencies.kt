package dependencies

object Dependencies {
    object Versions {
        const val KOTLIN = "1.5.21"
        const val BUILD_TOOLS_GRADLE = "7.0.2"

        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0"

        const val SDK_TARGET = 31
        const val SDK_MIN = 22
        const val SDK_COMPILE = 31

        object Libs {
            const val KOIN = "3.1.2"

            object AndroidX {
                const val MATERIAL = "1.3.0"
                const val CORE_KTX = "1.6.0"
                const val ACTIVITY_KTX = "1.3.1"
                const val APP_COMPAT = "1.3.1"
                const val COMPOSE = "1.0.2"
                const val NAVIGATION_COMPOSE = "2.4.0-alpha09"
                const val ACTIVITY_COMPOSE = "1.3.1"
                const val LIFECYCLE_COMPOSE = "1.0.0-alpha07"
            }
        }
    }

    object Plugins {
        const val KOTLIN_GRADLE = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val BUILD_TOOLS_GRADLE =
            "com.android.tools.build:gradle:${Versions.BUILD_TOOLS_GRADLE}"
    }

    object Koin {
        const val KOIN_ANDROID = "io.insert-koin:koin-android:${Versions.Libs.KOIN}"
        const val KOIN_COMPOSE = "io.insert-koin:koin-androidx-compose:${Versions.Libs.KOIN}"
        const val KOIN_VIEW_MODEL = "io.insert-koin:koin-android-viewmodel:${Versions.Libs.KOIN}"
    }

    object AndroidX {
        const val MATERIAL =
            "com.google.android.material:material:${Versions.Libs.AndroidX.MATERIAL}"
        const val CORE_KTX = "androidx.core:core-ktx:${Versions.Libs.AndroidX.CORE_KTX}"
        const val ACTIVITY_KTX = "androidx.core:core-ktx:${Versions.Libs.AndroidX.ACTIVITY_KTX}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.Libs.AndroidX.APP_COMPAT}"

        object Compose {
            const val ACTIVITY =
                "androidx.activity:activity-compose:${Versions.Libs.AndroidX.ACTIVITY_COMPOSE}"
            const val ANIMATION =
                "androidx.compose.animation:animation:${Versions.Libs.AndroidX.COMPOSE}"
            const val FOUNDATION =
                "androidx.compose.foundation:foundation:${Versions.Libs.AndroidX.COMPOSE}"
            const val ICONS =
                "androidx.compose.material:material-icons-core:${Versions.Libs.AndroidX.COMPOSE}"
            const val ICONS_EXTENDED =
                "androidx.compose.material:material-icons-extended:${Versions.Libs.AndroidX.COMPOSE}"
            const val JUNIT = "androidx.compose.ui:ui-test-junit4:${Versions.Libs.AndroidX.COMPOSE}"
            const val LIFECYCLE_VIEW_MODEL =
                "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Libs.AndroidX.LIFECYCLE_COMPOSE}"
            const val MATERIAL =
                "androidx.compose.material:material:${Versions.Libs.AndroidX.COMPOSE}"
            const val NAVIGATION =
                "androidx.navigation:navigation-compose:${Versions.Libs.AndroidX.NAVIGATION_COMPOSE}"
            const val RUNTIME = "androidx.compose.runtime:runtime:${Versions.Libs.AndroidX.COMPOSE}"
            const val UI = "androidx.compose.ui:ui:${Versions.Libs.AndroidX.COMPOSE}"
            const val UI_TOOLING =
                "androidx.compose.ui:ui-tooling:${Versions.Libs.AndroidX.COMPOSE}"
        }
    }
}
