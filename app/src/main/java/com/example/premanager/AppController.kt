package com.example.premanager

import android.app.Application
import android.util.Log
import com.example.prefmanagerlib.PrefManager

class AppController  : Application(){

    private val mTag = AppController::class.simpleName

    override fun onCreate() {
        super.onCreate()

        /**
         * ini Preference Manager
         */
        PrefManager(this)
            .setPreferenceName("aa")
            .setPreferenceMode(MODE_PRIVATE)
            .setListener(object : PrefManager.OnPreferenceListener{
                override fun onObjectInit() {
                    Log.e(mTag,"cccccc cccccccc ccccccccccc cccccc");
                }

                override fun onExceptionOccur(error: String?) {
                    Log.e(mTag,"error -> $error")
                }

                override fun onSaveString(key: String, value: String?) {
                    Log.e(mTag,"Key = $key    -  value = $value")
                }

                override fun onSaveInt(key: String, value: Int?) {
                    Log.e(mTag,"Key = $key    -  value = $value")
                }

                override fun onSaveFloat(key: String, value: Float?) {
                    Log.e(mTag,"Key = $key    -  value = $value")
                }

                override fun onSaveBoolean(key: String, value: Boolean?) {
                    Log.e(mTag,"Key = $key    -  value = $value")
                }

                override fun onSaveLong(key: String, value: Long?) {
                    Log.e(mTag,"Key = $key    -  value = $value")
                }

                override fun onSaveSetString(key: String, value: Set<String?>?) {
                    Log.e(mTag,"Key = $key    -  value = $value")
                }

            })
            .build()
    }
}