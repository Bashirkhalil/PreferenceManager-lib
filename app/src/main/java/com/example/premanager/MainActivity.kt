package com.example.premanager

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.prefmanagerlib.PrefManager

class MainActivity : AppCompatActivity() {

    private var mContext: Context = this
    private val mTag = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PrefManager.setBoolean("isLogin", true)
        Log.e(mTag, "${PrefManager.getBoolean("isLogin")}")

    }
}