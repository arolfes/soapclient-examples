package info.novatec.example.soapclients.springboot.soap

import org.apache.hello_world_soap_http.types.*
import org.springframework.ws.client.core.support.WebServiceGatewaySupport

class HelloWorldServiceConsumer : WebServiceGatewaySupport() {

    fun ping() {
        webServiceTemplate.marshalSendAndReceive(PingMe())
    }

    fun greetMe(name: String): String {
        val greetMeResponse = webServiceTemplate.marshalSendAndReceive(GreetMe().apply {
            requestType = name
        }) as GreetMeResponse
        return greetMeResponse.responseType
    }

    fun sayHi(): String {
        val sayHiResponse = webServiceTemplate.marshalSendAndReceive(SayHi()) as SayHiResponse
        return sayHiResponse.responseType
    }
}