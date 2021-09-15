
package com.example.discoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import org.json.JSONTokener

class MainActivity : AppCompatActivity() {
    lateinit var botNameView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_bot)
        getUserinfo()
        botNameView = findViewById<TextView>(R.id.editbot_botname)

    }
    val userAPIserve by lazy {
        UserRequest.create()
    }

    var disposable: Disposable? = null

    private fun getUserinfo() {

        disposable =
            userAPIserve.getuserinfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        val jsonObject = JSONTokener(result).nextValue() as JSONObject
                        botNameView.text= jsonObject.getString("bot_name") },
                    { error -> Log.d("RESULT:", error.message.toString()) }
                )
    }
}
