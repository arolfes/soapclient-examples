package info.novatec.examples.soapclient.quarkus

import info.novatec.examples.soapclient.quarkus.soap.HelloWorldServiceConsumer
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/hello")
class GreetingResource(
    private val helloWorldServiceConsumer: HelloWorldServiceConsumer
) {

    @GET
    @Path("/greetme/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    fun greetme(@PathParam("name") name: String) =
        """{"response":"${helloWorldServiceConsumer.greetMe(name)}"}"""

    @GET
    @Path("/sayhi")
    @Produces(MediaType.APPLICATION_JSON)
    fun sayHi() = """{"response":"${helloWorldServiceConsumer.sayHi()}"}"""

}