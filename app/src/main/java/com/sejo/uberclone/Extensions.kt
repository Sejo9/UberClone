package com.sejo.uberclone

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import java.lang.ref.WeakReference

fun View.showKeyboard() {
    this.requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

class EditTextKeyboardLifecycleObserver(private val editText: WeakReference<EditText>) :
        LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun openKeyboard() {
        editText.get()?.postDelayed({ editText.get()?.showKeyboard() }, 100)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun closeKeyboard() {
        editText.get()?.hideKeyboard()
    }
}