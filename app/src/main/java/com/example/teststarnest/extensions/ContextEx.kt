package com.example.teststarnest.extensions

import android.content.*
import android.graphics.*
import android.util.*
import java.io.*


/**
 * Created by tuyen.dang on 1/28/2024.
 */

internal fun Context.getFileFromAssets(fileName: String): Bitmap? {
    return try {
        // get input stream
        val ims: InputStream = assets.open(fileName)
        // load image as Drawable
        BitmapFactory.decodeStream(ims)
    } catch (ex: Exception) {
        Log.e("TTT", "Error: $ex")
        null
    }
}
 