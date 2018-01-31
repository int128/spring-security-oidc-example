package org.hidetake.oidc

import org.hidetake.oidc.keycloak.UserService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(private val userService: UserService) {

    @RequestMapping("/")
    fun index() = userService.findAll()

}
