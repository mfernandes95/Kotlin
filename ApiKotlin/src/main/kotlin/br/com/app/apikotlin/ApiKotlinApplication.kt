package br.com.app.apikotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiKotlinApplication

fun main(args: Array<String>) {
	runApplication<ApiKotlinApplication>(*args)
}
