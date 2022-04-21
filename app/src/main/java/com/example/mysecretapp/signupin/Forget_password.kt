package com.example.mysecretapp.signupin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mysecretapp.R
import com.example.mysecretapp.database.User
import com.example.mysecretapp.database.UserDB
import kotlinx.android.synthetic.main.forget_view.*
import kotlinx.android.synthetic.main.fragment_sing_up_tab.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Forget_password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forget_view)

        btn_recover.setOnClickListener {
            if(recover_email.text.isEmpty() || recover_old_password.text.isEmpty() || recover_new_password1.text.isEmpty() || recover_new_password2.text.isEmpty()){
                Toast.makeText(this, "Введены неверные данные!", Toast.LENGTH_SHORT).show()
            }
            else{
                if(recover_new_password1.text.toString() == recover_new_password2.text.toString()){
                    val user = UserDB.getDataBase(this).getAllDAO()
                    val thread = CoroutineScope(Dispatchers.IO).launch{
                        val isExist = user.getUser(recover_email.text.toString(), recover_old_password.text.toString())
                        if(isExist){
                            val user1 = User(recover_email.text.toString(), recover_new_password1.text.toString())
                            user.upsert(user1)
                            CoroutineScope(Dispatchers.Main).launch {
                                Toast.makeText(this@Forget_password, "Данные изменены!", Toast.LENGTH_SHORT).show()
                            }
                        }
                        else{
                            CoroutineScope(Dispatchers.Main).launch {
                                Toast.makeText(this@Forget_password, "Такого пользователя нет!", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
                else{
                    Toast.makeText(this, "Пароли не совпадают!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        btn_back.setOnClickListener {
            finish()
        }

    }
}