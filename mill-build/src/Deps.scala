package millbuild

import mill.*
import javalib.*

object Deps:
    object Versions:
        val cryptoconditions = "1.0.5"
        val feign            = "12.3"
        val jackson          = "2.14.3"
        val junit            = "5.13.1"
    end Versions

    object Attrs:
        extension (attrs: Seq[(String, String)]) def asAttrs: String = attrs.map(_ + "=" + _).mkString(sep = ";")
        val cryptoconditions = Seq(
          "exclude" -> "com.fasterxml.jackson.core:jackson-core",
          "exclude" -> "com.fasterxml.jackson.core:jackson-annotations",
          "exclude" -> "com.fasterxml.jackson.core:jackson-databind"
        ).asAttrs

        val awaitility = Seq("exclude" -> "org.hamcrest:hamcrest-core", "exclude" -> "org.hamcrest:hamcrest-library").asAttrs
    end Attrs

    val assertjCore = mvn"org.assertj:assertj-core:3.24.2"
    val awaitility  =
        mvn"org.awaitility:awaitility:4.2.0;exclude=org.hamcrest:hamcrest-core;exclude=org.hamcrest:hamcrest-library"
    val bcprovJdk18on    = mvn"org.bouncycastle:bcprov-jdk18on:1.78.1"
    val caffeine         = mvn"com.github.ben-manes.caffeine:caffeine:2.9.3"
    val cryptoConditions = mvn"com.ripple.cryptoconditions:crypto-conditions:${Versions
            .cryptoconditions};exclude=com.fasterxml.jackson.core:jackson-core;exclude=com.fasterxml.jackson.core:jackson-annotations;exclude=com.fasterxml.jackson.core:jackson-databind"
    val dockerJavaApi = mvn"com.github.docker-java:docker-java-api:3.3.4"
    val feignCore     = mvn"io.github.openfeign:feign-core:${Versions.feign}"
    val feignJackson  = mvn"io.github.openfeign:feign-jackson:${Versions.feign}"
    val guava         = mvn"com.google.guava:guava:32.1.1-jre"
    val hamcrest      = mvn"org.hamcrest:hamcrest:2.2"

    val jacksonAnnotations              = mvn"com.fasterxml.jackson.core:jackson-annotations:${Versions.jackson}"
    val jacksonCore                     = mvn"com.fasterxml.jackson.core:jackson-core:${Versions.jackson}"
    val jacksonDatabind                 = mvn"com.fasterxml.jackson.core:jackson-databind:${Versions.jackson}"
    val jacksonDatatypeCryptoconditions = mvn"com.ripple.cryptoconditions:jackson-datatype-cryptoconditions:${Versions
            .cryptoconditions};exclude=com.fasterxml.jackson.core:jackson-core;exclude=com.fasterxml.jackson.core:jackson-annotations;exclude=com.fasterxml.jackson.core:jackson-databind"
    val jacksonDatatypeGuava  = mvn"com.fasterxml.jackson.datatype:jackson-datatype-guava:${Versions.jackson}"
    val jacksonDatatypeJdk8   = mvn"com.fasterxml.jackson.datatype:jackson-datatype-jdk8:${Versions.jackson}"
    val jacksonDatatypeJsr310 = mvn"com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Versions.jackson}"

    val jsonPathAssert = mvn"com.jayway.jsonpath:json-path-assert:2.8.0"
    val jsonassert     = mvn"org.skyscreamer:jsonassert:1.5.1"

    val junitJupiterApi    = mvn"org.junit.jupiter:junit-jupiter-api:${Versions.junit}"
    val junitJupiterEngine = mvn"org.junit.jupiter:junit-jupiter-engine:${Versions.junit}"
    val junitJupiterParams = mvn"org.junit.jupiter:junit-jupiter-params:${Versions.junit}"

    val logbackClassic = mvn"ch.qos.logback:logback-classic:1.3.15"
    val mockitoCore    = mvn"org.mockito:mockito-core:3.7.7"
    val okhttp         = mvn"com.squareup.okhttp3:okhttp:4.11.0"
    val slf4jApi       = mvn"org.slf4j:slf4j-api:2.0.7"
    val testcontainers = mvn"org.testcontainers:testcontainers:1.20.2"
    val value          = mvn"org.immutables:value:2.9.3"
end Deps
