package com.example.networkgithubprofiledemo.Datasource.Remote

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.networkgithubprofiledemo.View.Adapter.UserAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.net.HttpURLConnection
import java.net.URL



    class HttpUrlConnectionHelper{
        fun getResponse(url : String) : String {

            var returnString = ""
            val url = URL(url)
            val connection = url.openConnection() as HttpURLConnection

            val stream = connection.inputStream
            var read = stream.read()

            while (read > 0){
                returnString = "$returnString${read.toChar()}"
                read = stream.read()

            }

            stream.close()
            return returnString

        }


    }
