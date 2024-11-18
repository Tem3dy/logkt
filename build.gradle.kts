plugins {
    kotlin("jvm") version "2.0.21"
}

java {
    toolchain { languageVersion = JavaLanguageVersion.of(17) }
}

kotlin { jvmToolchain(17) }