package com.example.mysecretapp.signupin

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.room.Room
import com.example.mysecretapp.R
import com.example.mysecretapp.database.User
import com.example.mysecretapp.database.UserDB
import kotlinx.android.synthetic.main.fragment_sign_in_tab.*
import kotlinx.android.synthetic.main.fragment_sing_up_tab.*
import kotlinx.android.synthetic.main.fragment_sing_up_tab.password2
import kotlinx.android.synthetic.main.fragment_sing_up_tab.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class signup_fragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.fragment_sing_up_tab, container, false)
        val context: Context = requireContext()
        val userEmail = view.email_reg.text
        val userPassword = view.password_reg.text
        val userPassword2 = view.password2.text
        val btnSignUp = view.findViewById<Button>(R.id.btn_signup)
        btnSignUp.setOnClickListener {
            if (userEmail.isEmpty() || userPassword.isEmpty() || userPassword2.isEmpty()) {
                Toast.makeText(activity, "Все поля должны быть заполнены!", Toast.LENGTH_SHORT).show()
            } else {
                if(userPassword.toString() != userPassword2.toString()){
                    Toast.makeText(activity, "Пароли должны быть одинковы!", Toast.LENGTH_SHORT).show()
                }
                else {
                    val user_db = UserDB.getDataBase(requireContext()).getAllDAO()
                    CoroutineScope(Dispatchers.IO).launch {

                        var user = user_db.getUser(userEmail.toString(), userPassword.toString())
                        if(user){
                            CoroutineScope(Dispatchers.Main).launch {
                                Toast.makeText(activity, "Такой пользователь уже существует!", Toast.LENGTH_SHORT).show()
                        }}
                        else{
                            val user = User(userEmail.toString(), userPassword.toString())
                            val userDataBase = UserDB.getDataBase(context)
                            val userDAO = userDataBase.getAllDAO()
                            userDAO.upsert(user)
                            CoroutineScope(Dispatchers.Main).launch {
                                Toast.makeText(activity, "Пользователь успешно зарегистрирован!", Toast.LENGTH_SHORT).show()
                            }
                        }

                    }

                }
                }
        }
        return view
    }

}