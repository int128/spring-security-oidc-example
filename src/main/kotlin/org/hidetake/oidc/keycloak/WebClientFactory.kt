package org.hidetake.oidc.keycloak

import org.springframework.http.HttpHeaders
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class WebClientFactory(private val configuration: ApiConfiguration, private val authorizedClientService: OAuth2AuthorizedClientService) {

    fun create(): WebClient =
        (SecurityContextHolder.getContext().authentication as? OAuth2AuthenticationToken)?.let { token ->
            authorizedClientService.loadAuthorizedClient<OAuth2AuthorizedClient>(token.authorizedClientRegistrationId, token.name)?.let { client ->
                val accessToken = client.accessToken
                WebClient.builder()
                    .baseUrl(configuration.uri)
                    .defaultHeader(HttpHeaders.AUTHORIZATION, "${accessToken.tokenType.value} ${accessToken.tokenValue}")
                    .build()
            }
        } ?: throw IllegalStateException("Invalid authentication object in security context")

}
