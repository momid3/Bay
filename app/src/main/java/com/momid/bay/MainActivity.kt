package com.momid.bay

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val bayViewModel : BayViewModel by inject()
    private val bayListAdapter = BayListAdapter(ArrayList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.recyclerview).apply {
            this.adapter = bayListAdapter
            this.layoutManager = LinearLayoutManager(context)
        }

        bayViewModel.messagesLiveData.observe(this) {
            bayListAdapter.addItem(it)
        }

        findViewById<ImageButton>(R.id.sendButton).setOnClickListener {
            findViewById<EditText>(R.id.bayEditText).apply {
                bayViewModel.sendSomeMessage(this.text.toString())
                bayListAdapter.addItem(this.text.toString())
                this.setText("")
            }
        }
    }
}
