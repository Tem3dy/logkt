plugins {
    kotlin("jvm") version "2.0.21"
}

repositories { mavenCentral() }
dependencies { implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1") }

java {
    toolchain { languageVersion = JavaLanguageVersion.of(17) }
}

kotlin { jvmToolchain(17) }
