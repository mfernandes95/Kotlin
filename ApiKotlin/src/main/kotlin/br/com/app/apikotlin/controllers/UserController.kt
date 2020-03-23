package br.com.app.apikotlin.controllers

import br.com.app.apikotlin.models.User
import br.com.app.apikotlin.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserController(@Autowired private val UserRepository : UserRepository) {

    @GetMapping("/users")
    fun getAllUsers() : List<User> = UserRepository.findAll()

    @PostMapping("/users")
    fun createUser(@Valid @RequestBody user : User) : User = UserRepository.save(user)

    @GetMapping("/users/{userId}")
    fun getUsers(@PathVariable userId : Long) : ResponseEntity<User> =
            UserRepository.findById(userId).map {
                ResponseEntity.ok(it)
            }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/users/{userId}")
    fun updateUser(@PathVariable userId : Long,@Valid @RequestBody updatedUser: User) : ResponseEntity<User> =
            UserRepository.findById(userId).map{
                val newUser = it.copy(name = updatedUser.name, email = updatedUser.email, password = updatedUser.password)
                ResponseEntity.ok().body(UserRepository.save(newUser))
            }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/users/{userId}")
    fun removeUsers(@PathVariable userId: Long) : ResponseEntity<Void> =
            UserRepository.findById(userId).map {
                UserRepository.delete(it)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())

}


