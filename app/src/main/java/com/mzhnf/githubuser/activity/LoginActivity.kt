package com.mzhnf.githubuser.activity

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mzhnf.core.utils.showToast
import com.mzhnf.githubuser.R
import com.mzhnf.githubuser.databinding.ActivityLoginBinding
import com.mzhnf.githubuser.utils.initView
import com.mzhnf.githubuser.viewmodel.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: ViewModel by viewModels()
    private lateinit var loadingDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadingDialog = initView(this, this)
        viewModel.checkLoginStatus()
        viewModel.isLoggedIn.observe(this){
            Log.d("STATUS LOGIN",it.toString())
            if (it){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
        binding.btnSignIn.setOnClickListener {
            val token = binding.edtToken.text.toString()
            if (token.isEmpty()) {
                showToast(this, "Token Gaada")
            } else {
//                showToast(this,"Token Ada")
                viewModel.login(token)
                viewModel.userData.observe(this) { userResponse ->
                    if (userResponse != null) {
                        if (userResponse.isLoading) {
                            loadingDialog.show()
                        }
                        if (userResponse.error.isNotEmpty()) {
                            loadingDialog.dismiss()
                            showToast(this, userResponse.error)
                        }
                        if (userResponse.success != null) {
                            loadingDialog.dismiss()
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }
                    }
                }
            }
        }

    }
}