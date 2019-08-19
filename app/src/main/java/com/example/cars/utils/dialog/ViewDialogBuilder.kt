package com.example.cars.utils.dialog

import android.view.View
import com.example.cars.utils.dialog.filter.FilterOptions

class ViewDialogBuilder internal constructor() {
    var view: View? = null
    var title: String? = null
    var message: String? = null
    var positiveButton: String? = null
    var negativeButton: String? = null
    var neutralButton: String? = null
    var success: (FilterOptions) -> Unit = {}
    var failure: () -> Unit = {}
    var neutral: () -> Unit = {}
}