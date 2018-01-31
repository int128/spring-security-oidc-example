package org.hidetake.oidc.keycloak

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties("keycloak.api")
open class ApiConfiguration {
    var uri: String = ""
}
