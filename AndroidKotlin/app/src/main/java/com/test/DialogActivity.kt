package com.test

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import kotlinx.android.synthetic.main.activity_dialog.*
import org.jetbrains.anko.*

//import org.jetbrains.anko.design.textInputEditText

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        btn_toast.setOnClickListener {
            toast("${if (it is Button) it.text else ""}")
        }

        btn_snackbar.setOnClickListener {

        }

        btn_selector.setOnClickListener {
            val countries = listOf("Russia", "USA", "Japan", "Australia")
            selector("Where are you from?", countries) { _, i ->
                toast("${countries[i]}")
            }
        }

        btn_alert.setOnClickListener {
            //            alert1()
//            alert2()
            alert3()
        }

        btn_progress.setOnClickListener {
            //progressDialog\indeterminateProgressDialog
            indeterminateProgressDialog(message = "Please wait a bit…", title = "Fetching data") {

            }
        }
    }

    private fun alert1() {
        AlertDialog.Builder(this)
            .setTitle("tip")
            .setMessage("are you sure?")
            .setPositiveButton("yes") { _, _ ->
                toast("yes")
            }.setNegativeButton("no", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, p1: Int) {
                    toast("no")
                }
            }).create().show()
    }

    private fun alert2() {
        alert("are you sure?", "tip") {
            positiveButton("yes") {
                toast("yes")
            }
            negativeButton("no") {
                toast("no")
            }
            //                yesButton {
            //                    toast("yes")
            //                }
            //                noButton {
            //                    toast("no")
            //                }
        }.show()
    }

    //自定义布局
    private fun alert3() {
        alert {
            customView {
//                textInputEditText() {
//
//                }
            }
        }.show()
    }

}
