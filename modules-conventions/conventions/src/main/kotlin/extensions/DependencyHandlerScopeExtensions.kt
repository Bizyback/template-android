package extensions

import AndroidModules
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.project

/**
 * PROJECT : Template
 * AUTHOR  : mambo
 * EMAIL   : mambobryan@gmail.com
 * DATE    : Wed 07 February 2024
 * TIME    : 1:00 pm
 */

fun DependencyHandlerScope.api(library: Any) {
    add("api", library)
}

fun DependencyHandlerScope.implementation(library: Any) {
    add("implementation", library)
}

fun DependencyHandlerScope.androidTestImplementation(library: Any) {
    add("androidTestImplementation", library)
}

fun DependencyHandlerScope.testImplementation(library: Any) {
    add("testImplementation", library)
}

fun DependencyHandlerScope.debugImplementation(library: Any) {
    add("debugImplementation", library)
}
