package br.com.app.apikotlin.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Entity(name = "Users")
data class User(
        @Id
        @GeneratedValue(
                strategy = GenerationType.IDENTITY) @field: NotNull val id : Long = 0,
        @field: NotBlank val name : String = "",
        @field: NotBlank val email : String = "",
        @field: NotBlank  val password: String = ""
)