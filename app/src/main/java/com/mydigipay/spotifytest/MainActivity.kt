package com.mydigipay.spotifytest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val test = AuthenticationRequest.Builder("ba05b9cd59634cefa8493ac961d76ed6",
            AuthenticationResponse.Type.TOKEN, "http://mydigipay.com/")
            .setScopes(arrayOf("user-top-read")).build()
        AuthenticationClient.openLoginActivity(this, 123, test)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val t = AuthenticationClient.getResponse(resultCode, data)
    }

}
