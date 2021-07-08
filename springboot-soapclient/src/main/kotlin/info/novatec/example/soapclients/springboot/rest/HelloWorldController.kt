package info.novatec.example.soapclients.springboot.rest

import info.novatec.example.soapclients.springboot.soap.HelloWorldServiceConsumer
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/hello")
class HelloWorldController(
    private val helloWorldServiceConsumer: HelloWorldServiceConsumer
) {

    @GetMapping(value = ["/greetme/{name}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun greetMe(@PathVariable name: String): ResponseEntity<String> {

        return ResponseEntity.ok("""{"response":"${helloWorldServiceConsumer.greetMe(name)}"}""")
    }

    @GetMapping(value = ["/sayhi"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun sayHi(): ResponseEntity<String> {

        return ResponseEntity.ok("""{"response":"${helloWorldServiceConsumer.sayHi()}"}""")
    }
}