package ru.msakhterov.results.ui.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_create_activity_dialog.*
import kotlinx.android.synthetic.main.fragment_delete_dialog.*
import kotlinx.android.synthetic.main.fragment_delete_dialog.cancel_btn
import ru.msakhterov.results.R
import ru.msakhterov.results.utils.Constants

class DeleteEntityDialogFragment : DialogFragment() {

    var activityId: Int? = null

    companion object {

        const val ARG_ACTIVITY_ID = "activity_id"
        const val TAG_RESULT_DELETE = "delete_result"
        const val TAG_RESULT_ACTIVITY_ID = "activity_id"

        fun getInstance (activityId: Int) : DeleteEntityDialogFragment {
            val args = Bundle()
            args.putInt(ARG_ACTIVITY_ID, activityId)
            val fragment = DeleteEntityDialogFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, 0);
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        arguments?.let {
            activityId = it.getInt(ARG_ACTIVITY_ID)
        }
        return inflater.inflate(R.layout.fragment_delete_dialog, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cancel_btn.setOnClickListener{sendResults(Constants.RESULT_CANCEL)}
        delete_btn.setOnClickListener{sendResults(Constants.RESULT_OK)}
    }

    fun sendResults(result: Int): Unit {
        val intent = Intent()
        intent.putExtra(TAG_RESULT_DELETE, result)
        if (result == Constants.RESULT_OK) {
            intent.putExtra(TAG_RESULT_ACTIVITY_ID, activityId)
        }
        targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
        dismiss();
    }
}