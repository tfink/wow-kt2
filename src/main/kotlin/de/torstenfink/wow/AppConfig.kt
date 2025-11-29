package de.torstenfink.wow

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.web.client.RestClient

@Configuration
class AppConfig {
    @Bean
    fun restClient(): RestClient {
        return RestClient.builder()
            .baseUrl("https://eu.api.blizzard.com/")
            .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer EUIevGNCR8FvsiMk7j5Z8WyWgVpIKss5wr")
            .defaultUriVariables(mapOf("namespace" to "profile-eu", "locale" to "en_GB"))
            .requestInterceptor(RestClientInterceptor())
            .build()
    }
}


class RestClientInterceptor: ClientHttpRequestInterceptor  {
    override fun intercept(
        request: HttpRequest,
        body: ByteArray,
        execution: ClientHttpRequestExecution
    ): ClientHttpResponse {
        println(request.headers)
        println(request.uri)
        return execution.execute(request, body)
    }

}