package com.example.sandy.kotlin_sqlite

import android.content.ContentValues
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dBase=openOrCreateDatabase("emp_db",Context.MODE_PRIVATE,null)
        dBase.execSQL("create table if not exists employee(_id integer primary key autoincrement,emp_id number,name varchar(100),email varchar(100),mob_no integer)")

        insertbtn.setOnClickListener {

            var cv=ContentValues()
            cv.put("emp_id",et1.text.toString().toInt())
            cv.put("name",et2.text.toString())
            cv.put("email",et3.text.toString())
            cv.put("mob_no",et4.text.toString())
            var check=dBase.insert("employee",null,cv)

            if (check!=-1.toLong()){

                Toast.makeText(this,"successful inserted",Toast.LENGTH_LONG).show()
                et1.setText("")
                et2.setText("")
                et3.setText("")
                et4.setText("")

            }else{

                Toast.makeText(this,"plz try again",Toast.LENGTH_LONG).show()

            }
        }
    }
}
