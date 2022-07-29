package com.acme.kotlinmvvm.utils

import android.content.Context
import android.content.SharedPreferences




class SessionManager {

    var pref: SharedPreferences? = null


    // Editor for Shared preferences
    var editor: SharedPreferences.Editor? = null
    private val PREF_NAME = "Iotglobal"

    var userId:String?=null

    // Context
    var _context: Context? = null

    // Shared pref mode
    var PRIVATE_MODE = 0


    constructor (context: Context ) {
        _context = context
        pref = _context!!.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref!!.edit()
    }

    // set is UserID
    fun getGUID(): String? {
        return pref!!.getString("GUID", "123")
    }

    // get is UserID
    fun setGUID(GUID: String?) {
        editor!!.putString("GUID", GUID)
        editor!!.commit()
    }
    // set is UserID
    fun getUserid(): String? {
        return pref!!.getString("Userid", null)
    }

    // get is UserID
    fun setUserid(Userid: String?) {
        editor!!.putString("Userid", Userid)
        editor!!.commit()
    }

}