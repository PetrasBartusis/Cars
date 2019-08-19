package com.example.cars.utils.activity

import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentActivity
import com.example.cars.MainActivity
import com.example.cars.utils.filter.FilterLayout
import com.example.cars.utils.dialog.ViewDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*

fun FragmentActivity.showMessage(message: String) {
    (this as MainActivity).showMessage(message)
}

fun FragmentActivity.showMessage(messageResId: Int) {
    (this as MainActivity).showMessage(getString(messageResId))
}

fun FragmentActivity.openDrawer() {
    drawer.openDrawer(GravityCompat.START)
}

fun FragmentActivity.carFilterDialog(apply: ViewDialogBuilder.() -> Unit): AlertDialog {
    val builder = ViewDialogBuilder()
    builder.apply()
    val carFilterLayout = FilterLayout(this, null)

    val dialog = AlertDialog.Builder(this).apply {
        setView(carFilterLayout)
        setTitle(builder.title)
        setMessage(builder.message)
        setPositiveButton(builder.positiveButton) { _, _ ->
            builder.success.invoke(carFilterLayout.value)
        }
        setNegativeButton(builder.negativeButton) { _, _ ->
            builder.failure.invoke()
        }
        setNeutralButton(builder.neutralButton) { _, _ ->
            builder.neutral.invoke()
        }
        setOnCancelListener {
            builder.failure.invoke()
        }
        builder.view?.let { setView(builder.view) }
    }
    return dialog.show()
}