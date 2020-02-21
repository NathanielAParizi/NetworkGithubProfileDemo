package com.example.networkgithubprofiledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.networkgithubprofiledemo.Datasource.Remote.OkHttpHelper
import com.example.networkgithubprofiledemo.Model.User.UserResponse
import com.example.networkgithubprofiledemo.View.Adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {

    // https://api.github.com/users/NathanielAParizi/repos
    // https://api.github.com/search/users?q=nathanielaparizi

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

            R.id.btn -> executeAsyncHttpOkCall()

        }
    }

    private fun executeAsyncHttpOkCall() {
        //SocketException in stacktrace

//        val githubUser = "https://api.github.com/search/users?q=nathanielaparizi"
//        val okHttpHelper = OkHttpHelper()
//        okHttpHelper.makeAsyncApiCall(githubUser)
    }


}
