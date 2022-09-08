package com.example.premanager

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.prefmanagerlib.PrefManager
import org.json.JSONObject

class MainActivity : AppCompatActivity() , PrefManager.OnPreferenceListener{

    private var mContext: Context = this
    private val mTag = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PrefManager.setLister(this)
        PrefManager.setBoolean("isLogin", true)
        Log.e(mTag, "${PrefManager.getBoolean("isLogin")}")

    }

    override fun onObjectInit() {
        TODO("Not yet implemented")
    }

    override fun onExceptionOccur(error: String?) {
        TODO("Not yet implemented")
    }

    override fun onSaveString(key: String, value: String?) {
        TODO("Not yet implemented")
    }

    override fun onSaveInt(key: String, value: Int?) {
        TODO("Not yet implemented")
    }

    override fun onSaveFloat(key: String, value: Float?) {
        TODO("Not yet implemented")
    }

    override fun onSaveBoolean(key: String, value: Boolean?) {
        Log.e(mTag,"onSaveBoolean -> ")
    }

    override fun onSaveLong(key: String, value: Long?) {
        TODO("Not yet implemented")
    }

    override fun onSaveSetString(key: String, value: Set<String?>?) {
        TODO("Not yet implemented")
    }

    override fun onSaveJSON(key: String, values: JSONObject?) {
        TODO("Not yet implemented")
    }

}