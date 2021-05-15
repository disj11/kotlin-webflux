package com.core.api

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@WebFluxTest
class HelloControllerTest(@Autowired val client: WebTestClient) {
    @Test
    fun helloTest() {
        client.get()
            .uri("/hello")
            .accept(MediaType.TEXT_PLAIN)
            .exchange()
            .expectStatus()
            .isOk
            .expectBody<String>()
            .isEqualTo("Hello")
    }
}