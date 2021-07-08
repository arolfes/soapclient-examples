package info.novatec.examples.soapclient.micronaut

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("info.novatec.examples.soapclient.micronaut")
		.start()
}

