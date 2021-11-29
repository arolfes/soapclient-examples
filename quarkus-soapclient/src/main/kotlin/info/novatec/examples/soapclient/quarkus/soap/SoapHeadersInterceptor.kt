package info.novatec.examples.soapclient.quarkus.soap

import io.quarkus.arc.Unremovable
import javax.inject.Inject
import javax.inject.Singleton
import javax.xml.namespace.QName
import org.apache.cxf.binding.soap.SoapHeader
import org.apache.cxf.binding.soap.SoapMessage
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor
import org.apache.cxf.jaxb.JAXBDataBinding
import org.apache.cxf.phase.Phase

@Unremovable
@Singleton
class SoapHeadersInterceptor(
    @Inject private val soapHeadersProperties : SoapHeadersProperties
) : AbstractSoapInterceptor(Phase.WRITE) {

    override fun handleMessage(message: SoapMessage) {
        message.headers.add(SoapHeader(QName("http://www.github.com/arolfes/quarkus/soap", "name", "nsl"), soapHeadersProperties.name(), JAXBDataBinding(String::class.java)))
        message.headers.add(SoapHeader(QName("http://www.github.com/arolfes/quarkus/soap", "id", "nsl"), soapHeadersProperties.id(), JAXBDataBinding(String::class.java)))
    }

}