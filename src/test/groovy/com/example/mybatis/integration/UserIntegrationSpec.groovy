package com.example.mybatis.integration

import com.example.mybatis.domain.User
import com.example.mybatis.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import com.example.mybatis.config.TestConfig

@SpringBootTest
@ContextConfiguration(classes = [TestConfig])
class UserIntegrationSpec extends Specification {
    @Autowired
    UserService userService

    def "should create and retrieve user"() {
        given: "a new user"
        def user = new User(name: "Test User", email: "test@example.com")

        when: "user is created"
        def createdUser = userService.createUser(user)

        then: "user is created successfully"
        createdUser.id != null
        createdUser.name == user.name
        createdUser.email == user.email

        when: "user is retrieved"
        def retrievedUser = userService.getUserById(createdUser.id)

        then: "retrieved user matches created user"
        retrievedUser.id == createdUser.id
        retrievedUser.name == createdUser.name
        retrievedUser.email == createdUser.email
    }
} 