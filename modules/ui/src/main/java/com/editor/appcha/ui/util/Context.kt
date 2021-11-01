package com.editor.appcha.ui.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.playStore(packageName: String = this.packageName) {
    try {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=${packageName}"))
        startActivity(intent)
    } catch (_: ActivityNotFoundException) {
        /* no-op */
    }
}
