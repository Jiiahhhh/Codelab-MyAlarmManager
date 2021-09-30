package com.ilal.myalarmmanager

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener{

    private var mListener: DialogDateListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = context as DialogDateListener?
    }

    override fun onDetach() {
        super.onDetach()
        if (mListener != null){
            mListener = null
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calender = Calendar.getInstance()
        val year = calender.get(Calendar.YEAR)
        val month = calender.get(Calendar.MONTH)
        val date = calender.get(Calendar.DATE)

        return DatePickerDialog(activity as Context,this, year, month, date )
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        mListener?.onDialogDataSet(tag, year, month, dayOfMonth)
    }

    interface DialogDateListener {
        fun onDialogDataSet(tag: String?, year: Int, month: Int, dayOfMonth: Int)
    }

}