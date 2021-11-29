package info.novatec.examples.soapclient.quarkus.soap

import io.smallrye.config.ConfigMapping

@ConfigMapping(prefix="soapheaders")
interface SoapHeadersProperties {

    fun name(): String

    fun id(): String

}