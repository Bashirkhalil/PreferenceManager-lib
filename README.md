## :slightly_smiling_face:  PreferenceManager-lib 

[![](https://jitpack.io/v/Bashirkhalil/PreferenceManager-lib.svg)](https://jitpack.io/#Bashirkhalil/PreferenceManager-lib)

Kotlin library help you avoid the biller code in sharedpreferences  just inject the the object into top level application class and used any where . 


## Features 

1. set your the object into top-level in your application ( Application class ).
2. set your reference name it's required  .
3. set your reference type is also required .
4. set your reference listener is optional  .
5. and last but not least call build the function   .



	
	
##  :heart: Gradle [ setting or project  Level ]


	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}

## :heart: Gradle [   Module Level ]
	
	
     dependencies  {
       implementation 'com.github.Bashirkhalil:PreferenceManager-lib:last_verstion'
     }
	

## :heart: Example 

import android.app.Application
import android.util.Log
import com.example.prefmanagerlib.PrefManager
import org.json.JSONObject

class AppController  : Application() {

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
                    Log.e(mTag,"Error occur -> $error")
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
//                    Log.e(mTag,"Key = $key    -  value = $value")
                }

                override fun onSaveJSON(key: String, values: JSONObject?) {
                    TODO("Not yet implemented")
                }


            })
            .build()
    }



## :heart: in your activity call or in everywhere  call the function



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

please  :fist_raised: I belive on other people ability they can develop more you can contributor and update :muscle: .
