package com.bangkit.kopintar.view.customView

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.util.PatternsCompat
import com.bangkit.kopintar.R

class CustomEditTextEmail @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
): AppCompatEditText(context, attrs) {
    override fun onTextChanged(
        text: CharSequence,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        if (!isValidEmail(text.toString())) {
            setError(context.getString(R.string.email_error), null)
        } else {
            error = null
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }
}