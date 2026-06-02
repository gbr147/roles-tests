package com.example.rolestest

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class HomeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val username = intent.getStringExtra("username") ?: ""
        val role = intent.getStringExtra("role") ?: ""

        setContent {

            HomeScreen(
                username = username,
                role = role,
                onAdminClick = {

                    startActivity(
                        Intent(this, AdminActivity::class.java)
                    )
                }
            )
        }
    }
}

@Composable
fun HomeScreen(
    username: String = "user",
    role: String = "user",
    onAdminClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Tela Principal",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Usuário: $username")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Role: $role")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onAdminClick
        ) {
            Text("Área Administrativa")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}