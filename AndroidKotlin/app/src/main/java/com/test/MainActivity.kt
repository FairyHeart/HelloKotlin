package com.test

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.test.R
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

const val RESULT_CODE = 100

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //android 6.0需要动态权限
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 10)
        this.testIntent()

        btn_dialog.setOnClickListener {
            startActivity<DialogActivity>()
        }

    }

    private fun testIntent() {
        btn_test.setOnClickListener {

            //            val intent = Intent(this, OtherActivity::class.java)
            //            intent.putExtra("key", "vaule")
            //            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
            //            startActivity(intent)

            //anko 中使用 newTask()、newSingle()等代替Intent.FLAG_ACTIVITY_SINGLE_TOP相应等启动模式
            //            val intent2 = Intent(this, OtherActivity::class.java)
            //            intent2.putExtra("key", "vaule")
            //            startActivityForResult(intent2.newTask(), RESULT_CODE)

            //anko 中新增intentFor写法
            //            startActivityForResult(intentFor<OtherActivity>("key" to "传递的值").newTask(), RESULT_CODE)

            //anko库新增写法
            //            startActivity<OtherActivity>(
            //                "key" to "传递的值",
            //                "key2" to "传递的值2"
            //            )

            startActivityForResult<OtherActivity>(
                RESULT_CODE,
                "key" to "传递的值",
                "key2" to "传递的值2"
            )

            //            makeCall("16657135763")
            //            browse("http:www.baidu.com", true)


        }
    }

    private inner class MyClick : View.OnClickListener {
        override fun onClick(view: View?) {
            Toast.makeText(this@MainActivity, "xx", Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        toast("$requestCode $resultCode ${data?.getStringExtra("result_key")}")
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults?.size > 0
            && grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            toast("权限被允许")
        } else {
            toast("权限被拒绝")
        }
    }
}
