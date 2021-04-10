package de.marphi.gurk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GurkApplication

fun main(args: Array<String>) {
	runApplication<GurkApplication>(*args)
}
