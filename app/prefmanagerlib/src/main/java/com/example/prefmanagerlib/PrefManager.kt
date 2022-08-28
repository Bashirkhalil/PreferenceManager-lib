package com.example.prefmanagerlib

import android.content.Context
import android.content.SharedPreferences

class PrefManager(mContext: Context) {

    private var mContext: Context? = null
    private var mPreferenceName: String? = null
    private var mPreferencesMode: Int? = null
    private lateinit var monPrefernceListner: onPrefernceListner

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

    fun setLinser(onPrefernceListner: onPrefernceListner) = apply{
        this.monPrefernceListner  = onPrefernceListner
    }

//    fun setLinser(onPrefernceListner: onPrefernceListner) {
//        this.monPrefernceListner  = monPrefernceListner
//    }


    companion object {

        private lateinit var mSharedPreferences: SharedPreferences

        fun setString(key: String?, Values: String?) {
            mSharedPreferences!!.edit().putString(key, Values).commit()
        }

        fun setBoolean(key: String?, Values: Boolean?) {
            mSharedPreferences!!.edit().putBoolean(key, Values!!).commit()
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

    }

    interface onPrefernceListner {
        fun onPreferenceInit()
        fun onError()
    }

}