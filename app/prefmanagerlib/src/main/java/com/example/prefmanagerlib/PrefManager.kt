package com.example.prefmanagerlib

import android.content.Context
import android.content.SharedPreferences

class PrefManager(private var mContext: Context) {

    private var mPreferenceName: String? = null
    private var mPreferencesMode: Int? = null


    companion object {

        private  var mSharedPreferences: SharedPreferences? =null
        lateinit var mOnPreferenceListener: OnPreferenceListener


        fun setString(key: String?, Values: String?) {
            mSharedPreferences!!.edit().putString(key, Values).commit()
        }

        fun setBoolean(key: String, Values: Boolean?) {
            mSharedPreferences!!.edit().putBoolean(key, Values!!).commit().also {
                mOnPreferenceListener.onSaveBoolean(key,Values)
            }
        }

        fun setFloat(key: String?, Values: Float?) {
            mSharedPreferences!!.edit().putFloat(key, Values!!).commit()
        }

        fun setInt(key: String?, Values: Int) {
            mSharedPreferences!!.edit().putInt(key, Values).commit()
        }

        fun setLong(key: String?, Values: Long?) {
            mSharedPreferences!!.edit().putLong(key, Values!!).commit()
        }

        fun setSetString(key: String?, Values: Set<String?>?) {
            mSharedPreferences!!.edit().putStringSet(key, Values).commit()
        }

        fun getPref(key: String?): String? {
            return mSharedPreferences!!.getString(key, "")
        }


      fun getBoolean(key: String?): Boolean? {
            return mSharedPreferences!!.getBoolean(key, false)
        }


    }

    interface OnPreferenceListener {
        fun onObjectInit()
        fun onExceptionOccur(error:String)
        fun onSaveString(key:String,value:String)
        fun onSaveInt(key:String,value:Int)
        fun onSaveFloat(key:String,value:Float)
        fun onSaveBoolean(key:String,value:Boolean)
        fun onSaveLong(key:String,value:Long)
        fun onSaveSetString(key:String,value:Set<String?>?)
    }

    fun setPreferenceName(title: String) = apply { mPreferenceName = title }

    fun setPreferenceMode(content: Int) = apply { mPreferencesMode = content }

    fun build() {

        if (mContext==null){

            return
        }

        if (mPreferenceName==null){
            return
        }

        if (mPreferencesMode==null){

            return
        }

        buildSharedPreferences()
    }

    private fun buildSharedPreferences() {
        mSharedPreferences = mContext!!.getSharedPreferences(mPreferenceName, mPreferencesMode!!)
    }

    fun setListener(onPreferenceListener: OnPreferenceListener) = apply{
        mOnPreferenceListener  = onPreferenceListener
    }


}