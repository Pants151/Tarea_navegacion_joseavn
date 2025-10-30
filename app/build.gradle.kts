plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.tarea_navegacion_joseavn"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.tarea_navegacion_joseavn"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    // Habilitar ViewBinding
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Dependencias existentes
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Dependencias de Navigation Component
    implementation("androidx.navigation:navigation-fragment:2.7.7")
    implementation("androidx.navigation:navigation-ui:2.7.7")

    // Dependencia de ViewPager2
    implementation("androidx.viewpager2:viewpager2:1.1.0")

    // Dependencias de Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}