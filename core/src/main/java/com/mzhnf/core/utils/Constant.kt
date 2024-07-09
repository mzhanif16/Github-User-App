package com.mzhnf.core.utils

import android.content.Context
import android.util.Base64
import android.widget.Toast
import java.security.Key
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

private const val encryptionKey = "1234567890123456"

const val BASE_URL = "https://api.github.com/"
val CODE = arrayOf(400, 403, 404, 409, 500, 304)

fun String.encrypt(): String {
    val key: Key = SecretKeySpec(encryptionKey.toByteArray(), "AES")
    val cipher: Cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.ENCRYPT_MODE, key)
    val encryptedValue = cipher.doFinal(this.toByteArray())
    return Base64.encodeToString(encryptedValue, Base64.DEFAULT)
}

fun String.decrypt(): String {
    val key: Key = SecretKeySpec(encryptionKey.toByteArray(), "AES")
    val cipher: Cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    cipher.init(Cipher.DECRYPT_MODE, key)
    val decodedValue = Base64.decode(this, Base64.DEFAULT)
    val decryptedValue = cipher.doFinal(decodedValue)
    return String(decryptedValue)
}

fun showToast(context: Context, message:String){
    Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
}