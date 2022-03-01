package com.example.routes

import com.example.models.ApiResponse
import com.example.repository.HeroRepository
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllHeroes() {

    val heroesRepository : HeroRepository by inject()

    get("/boruto/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)

            call.respond(
                message = heroesRepository.getAllHeroes(page)
            )
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(success = false, "Only numbers allowed."),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(success = false, "Heroes not found."),
                status = HttpStatusCode.NotFound
            )
        }


    }
}