# Gradle Artifact Plugin
(version: 0.0.2)

## Overview
Simple plugin that adds two tasks for making source and javadoc jar

## Install
```kotlin
buildscript {
    repositories {
        maven(url = "https://artfable.jfrog.io/artifactory/default-maven-local")
    }
    dependencies {
        classpath("com.artfable.gradle:gradle-artifact-plugin:0.0.2")
    }
}

apply(plugin = "artfable.artifact")
```

## Usage
Just call `javadocJar` or `sourceJar` task