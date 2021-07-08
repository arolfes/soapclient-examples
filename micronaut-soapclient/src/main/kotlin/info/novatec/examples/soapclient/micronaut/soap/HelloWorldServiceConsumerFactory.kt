package info.novatec.examples.soapclient.micronaut.soap

import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Value
import org.apache.hello_world_soap_http.Greeter
import org.apache.hello_world_soap_http.SOAPService
import javax.xml.ws.BindingProvider

import javax.inject.Singleton

@Factory
class HelloWorldServiceConsumerFactory {

    @Singleton
    fun cxfGreeterService(@Value("\${greeter.url}") endpointUrl: String): Greeter {
        val cxfClient: Greeter = SOAPService().soapPort
        (cxfClient as BindingProvider).requestContext[BindingProvider.ENDPOINT_ADDRESS_PROPERTY] =
            endpointUrl
        return cxfClient
    }
}