package com.example.premanager

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.prefmanagerlib.PrefManager

class MainActivity : AppCompatActivity() {

    var mContext:Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        PrefManager(mContext)
            .setPreferenceName("")
            .setPreferenceMode(0)
            .setLinser(object :PrefManager.onPrefernceListner{
                override fun onPreferenceInit() {
                    Log.e("fff","cccccc cccccccc ccccccccccc cccccc");
                }

                override fun onError() {
                    Log.e("fff","fffff");
                }

            })
            .build()
    }
}