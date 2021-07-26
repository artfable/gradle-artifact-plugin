# Gradle Artifact Plugin
(version: 0.0.3)

## Overview
Simple plugin that adds two tasks for making source and javadoc jar

## Install
```kotlin
buildscript {
    repositories {
        maven(url = "https://artfable.jfrog.io/artifactory/default-maven-local")
    }
    dependencies {
        classpath("com.artfable.gradle:gradle-artifact-plugin:0.0.3")
    }
}

apply(plugin = "artfable.artifact")
```

## Usage
Call `javadocJar` or `sourceJar` task

`artifactoryCredentials.user` and `artifactoryCredentials.key` will contain values from gradle properties 
`artifactoryUser` and `artifactoryKey` or from env vars if properties aren't provided `ARTIFACTORY_USER` and `ARTIFACTORY_KEY`