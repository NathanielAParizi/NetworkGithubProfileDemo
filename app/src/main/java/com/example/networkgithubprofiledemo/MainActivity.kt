package com.example.networkgithubprofiledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.networkgithubprofiledemo.Datasource.Remote.HttpUrlConnectionHelper
import com.example.networkgithubprofiledemo.Datasource.Remote.OkHttpHelper
import com.example.networkgithubprofiledemo.Model.User.UserResponse
import com.example.networkgithubprofiledemo.View.Adapter.UserAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    // https://api.github.com/users/NathanielAParizi/repos
    // https://api.github.com/search/users?q=nathanielaparizi

   val profileFragment by lazy{ProfileFragment()}
    val repoFragment by lazy{RepoFragment()}
    lateinit var profileData : String
    lateinit var repoData : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onUserResponse(userResponse: UserResponse) {
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = UserAdapter(userResponse.items)
    }

    fun onClick(view: View) {

        when (view.id) {

            R.id.btn -> executeAsyncOkHttpCall()


        }
    }
    private fun executeAsyncOkHttpCall() {
        val randomUserURL = "https://api.github.com/search/users?q=nathanielaparizi"
        val okHttpHelper = OkHttpHelper()
        okHttpHelper.makeAsyncApiCall(randomUserURL)
    }

}
