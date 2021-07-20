package com.lakshyagupta7089.agora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.lakshyagupta7089.agora.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private var binding: ActivitySignUpBinding ?= null
    private var auth: FirebaseAuth?= null
    private var fireStore: FirebaseFirestore ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding!!.root)

        auth = FirebaseAuth.getInstance()
        fireStore = FirebaseFirestore.getInstance()

        binding!!.createBtn.setOnClickListener {
            val email: String = binding!!.emailBox.text.toString()
            val userName: String = binding!!.userName.text.toString()
            val password: String = binding!!.passwordBox.text.toString()

            val user = UserModel()

            user.email = email
            user.name = userName
            user.password = password

            auth!!.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        fireStore!!.collection("Users")
                            .document()
                            .set(user)
                            .addOnSuccessListener {
                                finish()
                            }

                        // Toast.makeText(applicationContext, "Account is created", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, it.exception!!.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}