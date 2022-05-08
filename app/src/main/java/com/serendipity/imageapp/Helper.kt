package com.serendipity.imageapp

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

fun ImageView.loadUrl(url: String?) {
    Picasso.get().load(url).into(this)
}
fun Context.getToast(message: String){
    Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
}