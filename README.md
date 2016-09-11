# Gradle Artifact Plugin
(version: 0.0.1)

## Overview
Simple plugin that adds two tasks for make source an javadoc jar

## Install
```groovy
buildscript {
    repositories {
        maven {
            url 'http://dl.bintray.com/artfable/gradle-plugins'
        }
    }
    dependencies {
        classpath "com.github.artfable.gradle:gradle-artifact-plugin:0.0.1"
    }
}

apply plugin: 'artfable.artifact'
```

## Usage
Just call `javadocJar` or `sourceJar` task