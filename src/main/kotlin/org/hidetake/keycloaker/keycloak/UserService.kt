package org.hidetake.keycloaker.keycloak

import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class UserService(private val factory: WebClientFactory) {

    fun findAll(): Flux<User> =
        factory.create().get().uri("/users").exchange().flatMapMany { response ->
            response.bodyToFlux(User::class.java)
        }

}
