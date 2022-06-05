package tech.zone84.examples.versioncatalogs

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class HelloEndpoint {
    @GetMapping("/hello", produces = ["text/plain"])
    fun hello(): String {
        logger.info { "Hit /hello endpoint" }
        return "hello"
    }

    companion object {
        var logger = KotlinLogging.logger { }
    }
}