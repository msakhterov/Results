package ru.msakhterov.results.ui.fragments

import android.app.Activity
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_create_activity_dialog.*
import ru.msakhterov.results.R
import ru.msakhterov.results.utils.Constants

class CreateActivityDialogFragment : DialogFragment() {

    companion object {

        const val TAG_RESULT_CREATE = "create_result"
        const val TAG_RESULT_TITLE = "create_title"
        const val TAG_RESULT_UNITS = "create_units"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dialog.setTitle(R.string.add_activity)
        dialog.window.setBackgroundDrawableResource(R.color.white)
        dialog.findViewById<TextView>(android.R.id.title).setTextColor(ContextCompat.getColor(context!!, R.color.colorPrimary))
        return inflater.inflate(R.layout.fragment_create_activity_dialog, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cancel_btn.setOnClickListener{sendResults(Constants.RESULT_CANCEL)}
        ok_btn.setOnClickListener{sendResults(Constants.RESULT_OK)}
    }

    fun sendResults(result: Int): Unit {
        val intent = Intent()
        intent.putExtra(TAG_RESULT_CREATE, result)
        if (result == Constants.RESULT_OK){
           intent.putExtra(TAG_RESULT_TITLE, et_activity_title.text.toString())
           intent.putExtra(TAG_RESULT_UNITS, et_activity_units.text.toString())
        }
//        getTargetFragment()?.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent)

//        getTargetFragment()?.let { it.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent) }

//        targetFragment?.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent)

        targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)

        dismiss();
    }
}