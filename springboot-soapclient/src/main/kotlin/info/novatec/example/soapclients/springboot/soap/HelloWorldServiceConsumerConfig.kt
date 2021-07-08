package info.novatec.example.soapclients.springboot.soap

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.oxm.jaxb.Jaxb2Marshaller

@Configuration
class HelloWorldServiceConsumerConfig {

    @Bean
    fun jaxb2Marshaller() = Jaxb2Marshaller().apply {
        setPackagesToScan("org.apache.hello_world_soap_http.types")
    }

    @Bean
    fun helloWorldServiceConsumer(
        @Value("\${helloWorldService.url}") url: String
    ) =
        HelloWorldServiceConsumer().apply {
            defaultUri = url
            marshaller = jaxb2Marshaller()
            unmarshaller = jaxb2Marshaller()
        }
}