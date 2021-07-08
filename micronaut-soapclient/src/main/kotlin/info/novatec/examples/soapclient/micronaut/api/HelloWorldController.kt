package info.novatec.examples.soapclient.micronaut.api

import info.novatec.examples.soapclient.micronaut.soap.HelloWorldServiceConsumer
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Produces

@Controller("/hello")
class HelloWorldController(
    private val helloWorldServiceConsumer: HelloWorldServiceConsumer
) {

    @Get("/greetme/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    fun greetme(@PathVariable("name") name: String) =
        """{"response":"${helloWorldServiceConsumer.greetMe(name)}"}"""

    @Get("/sayhi")
    @Produces(MediaType.APPLICATION_JSON)
    fun sayHi() = """{"response":"${helloWorldServiceConsumer.sayHi()}"}"""
}