package info.novatec.examples.soapclient.micronaut.soap

import org.apache.hello_world_soap_http.Greeter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HelloWorldServiceConsumer(
    private val cxfGreeterService: Greeter
) {

    fun ping() {
        cxfGreeterService.pingMe()
    }

    fun greetMe(name: String) = cxfGreeterService.greetMe(name)

    fun sayHi() = cxfGreeterService.sayHi()

}