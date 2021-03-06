package com.example.mysecretapp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import com.example.mysecretapp.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.*
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysecretapp.databinding.ActivityMainBinding.inflate
import com.example.mysecretapp.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.activity_dialog.view.*
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.view.*
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Retrofit
import java.io.IOException

class SecondFragment : Fragment(R.layout.fragment_second) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /// RecyclerView
        var list = mutableListOf<Word>(
            Word("jopa", false)
        )

        val view = layoutInflater.inflate(R.layout.fragment_second, container, false)

        val adapter = WordsAdapter(list)
        view.rcView.adapter = adapter
        view.rcView.layoutManager = LinearLayoutManager(activity)

        // views

        val v = layoutInflater.inflate(R.layout.activity_dialog, container, false)

        view.add_button.setOnClickListener {
            val dialog = activity?.let { it1 ->
                AlertDialog.Builder(it1)
                    .setTitle("sdsdsd")
                    .setView(v)
                    .setPositiveButton("OK") { dialogInterface, i ->
                        val parent:ViewGroup? = v.parent as? ViewGroup
                        parent?.removeView(v)
                        val title = v.findViewById<EditText>(R.id.edTextDialog).text
                        val word = Word(title.toString(), false)
                        if (title.isNotEmpty()) {
                            title.clear()
                            list.add(word)
                            adapter.notifyDataSetChanged()
                            Toast.makeText(activity,
                                "???? ???????????????? Item",
                                Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(
                                activity,
                                "???????? ???????????? ???????? ??????????????????!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        dialogInterface.dismiss()
                    }
                    .setNegativeButton("??????????") { dialog, _ ->
                        Toast.makeText(activity, "??????????", Toast.LENGTH_SHORT).show()
                        dialog.cancel()
                    }
                    .create()
            }
            dialog?.show()
        }
        return view
    }
    }




