package info.novatec.examples.soapclient.quarkus.soap

import io.quarkiverse.cxf.annotation.CXFClient
import org.apache.hello_world_soap_http.Greeter
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class HelloWorldServiceConsumer(
    @CXFClient("greeterService")
    private val cxfGreeterService: Greeter
) {

    fun ping() {
        cxfGreeterService.pingMe()
    }

    fun greetMe(name: String) = cxfGreeterService.greetMe(name)

    fun sayHi() = cxfGreeterService.sayHi()
}