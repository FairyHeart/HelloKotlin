package com.test.testandroidkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.test.R
import kotlinx.android.synthetic.main.activity_other.*
import org.jetbrains.anko.toast

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        toast("${intent.getStringExtra("key")} ${intent.extras.getString("key2")}")

        btn_back.setOnClickListener {
            var intent = Intent()
            intent.putExtra("result_key", "result_value")
            setResult(1, intent)
            finish()
        }
    }
}
