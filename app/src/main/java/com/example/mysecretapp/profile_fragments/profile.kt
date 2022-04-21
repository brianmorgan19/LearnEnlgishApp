package com.example.mysecretapp.profile_fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.mysecretapp.R
import kotlinx.android.synthetic.main.fragment_profile.*

class profile : Fragment(R.layout.fragment_profile) {
    lateinit var builder:AlertDialog
    private val viewModel: FragmentViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view = layoutInflater.inflate(R.layout.fragment_profile, container, false)
        val view_dialog = layoutInflater.inflate(R.layout.change_name, container, false)

        var edit = view.findViewById<ImageView>(R.id.edit)

        var name = view.findViewById<TextView>(R.id.id_name_profile)
        var editText = view_dialog.findViewById<EditText>(R.id.dialog_editText)
        var image = view.findViewById<ImageView>(R.id.imageView3)

        // creating dialog
        val dialog = AlertDialog.Builder(activity)
        dialog.setTitle("Вы точно уверены, что хотите поменять данные?")
        dialog.setView(view_dialog)
        dialog.create()

        // clicked
        edit.setOnClickListener {
            val parent:ViewGroup? = view_dialog.parent as? ViewGroup
            parent?.removeView(view_dialog)
            dialog.show()
        }

        viewModel.data.observe(viewLifecycleOwner){
            image.setImageResource(0)
            var uri = it
            image.setImageURI(uri)
        }

        // submit button ( dialog )
        val submit = view_dialog.findViewById<Button>(R.id.btn_change)
        submit.setOnClickListener {
            name.text = editText.text.toString()
            editText.text.clear()

        }

        return view
    }



}