package com.example.prefmanagerlib

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

class PrefManager(private var mContext: Context) {

    private var mPreferenceName: String? = null
    private var mPreferencesMode: Int? = null


    companion object {

        private val mTag = PrefManager::class.java.simpleName
        private var mSharedPreferences: SharedPreferences? = null
        private var mOnPreferenceListener: OnPreferenceListener? = null

        fun getListener() = mOnPreferenceListener

        fun setString(key: String, Values: String?) {
            try {
                mSharedPreferences!!.edit().putString(key, Values).commit()
                getListener()?.onSaveString(key, Values)

            } catch (e: Exception) {
                getListener()?.onExceptionOccur("Exception occur : setString function -> $e !!! ")
                Log.e(mTag, "Exception occur : $e")
            }
        }

        fun setBoolean(key: String, Values: Boolean?) {
            try {
                mSharedPreferences!!.edit().putBoolean(key, Values!!).commit().also {
                    getListener()?.onSaveBoolean(key, Values)
                }
            } catch (e: Exception) {
                getListener()?.onExceptionOccur("Exception occur : setBoolean function -> $e !!! ")
                Log.e(mTag, "Exception occur : $e")
            }
        }

        fun setFloat(key: String, Values: Float?) {
            try {
                mSharedPreferences!!.edit().putFloat(key, Values!!).commit()
                getListener()?.onSaveFloat(key, Values)
            } catch (e: Exception) {
                getListener()?.onExceptionOccur("Exception occur : setFloat function -> $e !!! ")
                Log.e(mTag, "Exception occur : $e")
            }
        }

        fun setInt(key: String, Values: Int) {
            try {
                mSharedPreferences!!.edit().putInt(key, Values).commit()
                getListener()?.onSaveInt(key, Values)
            } catch (e: Exception) {
                getListener()?.onExceptionOccur("Exception occur : setInt function -> $e !!! ")
                Log.e(mTag, "Exception occur : $e")
            }
        }

        fun setLong(key: String, Values: Long?) {

            try {
                mSharedPreferences!!.edit().putLong(key, Values!!).commit()
                getListener()?.onSaveLong(key, Values)
            } catch (e: Exception) {
                getListener()?.onExceptionOccur("Exception occur : setLong function -> $e !!! ")
                Log.e(mTag, "Exception occur : $e")
            }
        }

        fun setSetString(key: String, Values: Set<String?>?) {

            try {
                mSharedPreferences!!.edit().putStringSet(key, Values).commit()
                getListener()?.onSaveSetString(key, Values)
            } catch (e: Exception) {
                getListener()?.onExceptionOccur("Exception occur : setSetString function -> $e !!! ")
                Log.e(mTag, "Exception occur : $e")
            }
        }

        fun getPref(key: String?): String? {
            return mSharedPreferences!!.getString(key, "")
        }


        fun getBoolean(key: String?): Boolean? {
            return mSharedPreferences!!.getBoolean(key, false)
        }

        fun getSharedPreferences() = try {
            mSharedPreferences
        }catch (e:Exception){
            null
            getListener()?.onExceptionOccur("Exception occur : getSharedPreferences function -> $e !!! ")
            Log.e(mTag, "Exception occur : $e")
        }

    }

    interface OnPreferenceListener {
        fun onObjectInit()
        fun onExceptionOccur(error: String?)
        fun onSaveString(key: String, value: String?)
        fun onSaveInt(key: String, value: Int?)
        fun onSaveFloat(key: String, value: Float?)
        fun onSaveBoolean(key: String, value: Boolean?)
        fun onSaveLong(key: String, value: Long?)
        fun onSaveSetString(key: String, value: Set<String?>?)
    }

    fun setPreferenceName(title: String) = apply { mPreferenceName = title }

    fun setPreferenceMode(content: Int) = apply { mPreferencesMode = content }

    fun build() {

        if (mContext == null) {
            getListener()?.onExceptionOccur("Exception occur : Context is null plz put ( this ) !!! ")
            return
        }

        if (mPreferenceName == null) {
            getListener()?.onExceptionOccur("Exception occur : Preference name is null plz put ( any suitable name like app-reference ) !!! ")
            return
        }

        if (mPreferencesMode == null) {
            getListener()?.onExceptionOccur("Exception occur : Preference Mode is null plz put ( any suitable name like MODE_PRIVATE ) !!! ")
            return
        }

        buildSharedPreferences()
    }

    private fun buildSharedPreferences() {
        mSharedPreferences = mContext!!.getSharedPreferences(mPreferenceName, mPreferencesMode!!)
    }

    fun setListener(onPreferenceListener: OnPreferenceListener) = apply {
        mOnPreferenceListener = onPreferenceListener
    }


}