package info.novatec.examples.soapclient.quarkus.soap

import io.quarkus.test.junit.QuarkusTest
import javax.inject.Inject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@QuarkusTest
class SoapHeadersPropertiesTest {

    @Inject
    lateinit var soapHeadersProperties : SoapHeadersProperties

    @Test
    fun `should load soapHeaderProperties, when application is started`() {
        assertThat(soapHeadersProperties).isNotNull
        assertThat(soapHeadersProperties.name()).isEqualTo("Test")
        assertThat(soapHeadersProperties.id()).isEqualTo("00001")
    }
}