package com.mzhnf.githubuser.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mzhnf.core.utils.decrypt
import com.mzhnf.githubuser.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tvEncrypted = intent.getStringExtra("ENCRYPTED_TEXT").toString()
        val tvDecryptedValue = tvEncrypted.decrypt()
        binding.tvIntent.text = "Encrypted value : $tvEncrypted\nDecrypted value : $tvDecryptedValue"
        Log.d("DECRYPTED VALUE",tvDecryptedValue)
        Log.d("ENCRYPTED VALUE",tvEncrypted)

    }
}