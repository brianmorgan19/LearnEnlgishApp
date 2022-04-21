package com.example.mysecretapp.signupin

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ServiceCompat
import androidx.fragment.app.Fragment
import com.example.mysecretapp.MainActivity
import com.example.mysecretapp.R
import com.example.mysecretapp.SecondFragment
import com.example.mysecretapp.database.User
import com.example.mysecretapp.database.UserDB
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.forget_view.*
import kotlinx.android.synthetic.main.forget_view.view.*
import kotlinx.android.synthetic.main.fragment_sign_in_tab.*
import kotlinx.android.synthetic.main.fragment_sign_in_tab.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.w3c.dom.Text

class login_fragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_sign_in_tab, container, false)


        val btn = view.findViewById<Button>(R.id.btn_signign)
        val btn_forgot = view.findViewById<TextView>(R.id.tvView)

        // Forget password
        btn_forgot.setOnClickListener {
            val intent = Intent(activity, Forget_password::class.java)
            startActivity(intent)
        }

        btn.setOnClickListener {
            val user = UserDB.getDataBase(requireContext()).getAllDAO()
            CoroutineScope(Dispatchers.IO).launch {
                val isExist = user.getUser(email.text.toString(), password.text.toString())
                if(isExist){
                    CoroutineScope(Dispatchers.Main).launch {
                        Intent(activity, MainActivity::class.java).also {
                            startActivity(it)
                        }
                    }
                }
                else{
                    CoroutineScope(Dispatchers.Main).launch{
                        Toast.makeText(activity, "Неправильный логин/пароль.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        return view
    }

}