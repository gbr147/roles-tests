package com.example.rolestest.data

import com.example.rolestest.model.User

object FakeDatabase {

    val users = listOf(
        User(
            username = "user",
            password = "123",
            role = "user"
        )
    )
}