package org.hidetake.keycloaker

import org.hidetake.keycloaker.keycloak.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Example(private val userService: UserService) {

    @RequestMapping("/hello")
    fun hello() = userService.findAll()

}
