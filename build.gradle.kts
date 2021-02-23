plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm") version "1.4.30"
}

repositories {
    jcenter()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

group = "org.example"
version = "1.0-SNAPSHOT"

