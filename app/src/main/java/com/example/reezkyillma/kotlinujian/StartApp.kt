package com.example.reezkyillma.kotlinujian

import android.app.Application
import com.example.reezkyillma.kotlinujian.data.PenerbitRepo

class StartApp :Application(){

    fun getBookRepo() = PenerbitRepo(this)
}