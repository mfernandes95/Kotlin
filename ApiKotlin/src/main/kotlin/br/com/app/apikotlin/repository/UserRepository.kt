package br.com.app.apikotlin.repository

import br.com.app.apikotlin.models.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long >{
}