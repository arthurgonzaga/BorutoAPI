package com.example.routes

import com.example.repository.HeroRepository
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.searchHeroes() {

    val heroRepository: HeroRepository by inject()

    get("boruto/heroes/search") {
        val name = call.request.queryParameters["name"]
        call.respond(
            message = heroRepository.searchHeroes(name = name)
        )
    }
}