package com.mzhnf.githubuser.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import com.mzhnf.githubuser.R

fun initView(context: Context, activity: Activity): Dialog {
    val progressDialog = Dialog(context)
    val dialogLayout = activity.layoutInflater.inflate(R.layout.dialog_loader, null)
    progressDialog.apply {
        setContentView(dialogLayout)
        setCancelable(false)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
    }
    return progressDialog
}
