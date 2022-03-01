package com.example.routes

import com.example.models.ApiResponse
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.getAllHeroes() {
    get("/boruto/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)

            call.respond(
                message = ApiResponse(
                    success = true,
                    heroes =
                )
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