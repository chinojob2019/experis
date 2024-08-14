plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")



}

android {
    namespace = "christian.loayza.retoexperis"
    compileSdk = 34

    defaultConfig {
        applicationId = "christian.loayza.retoexperis"
        minSdk = 24
        targetSdk = 34
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation("com.google.dagger:hilt-android:2.51")
    implementation(libs.play.services.maps)
    kapt("com.google.dagger:hilt-android-compiler:2.51")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    //Corrutinas
    implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    implementation ("androidx.room:room-ktx:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.4")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.14.2")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")

    //Maps
    implementation ("com.google.android.gms:play-services-maps:18.1.0")
    implementation(libs.lottie)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
kapt {
    correctErrorTypes = true
}