package com.lakshyagupta7089.agora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.lakshyagupta7089.agora.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private var binding: ActivityLoginBinding ?= null
    private var auth: FirebaseAuth ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding!!.root)

        auth = FirebaseAuth.getInstance()

        if (auth!!.currentUser != null) {
            startActivity(
                Intent(applicationContext, DashBoardActivity::class.java)
            )
        }

        binding!!.createBtn.setOnClickListener {
            startActivity(Intent(applicationContext, SignUpActivity::class.java))
        }

        binding!!.logIn.setOnClickListener {
            val email: String = binding!!.emailBox.text.toString()
            val password: String = binding!!.passwordBox.text.toString()

            auth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        startActivity(
                            Intent(applicationContext, DashBoardActivity::class.java)
                        )

                        finish()
                        Toast.makeText(applicationContext, "Log in", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, it.exception!!.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}