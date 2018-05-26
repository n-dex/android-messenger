package com.github.ndex.messenger.demo_module.presentation

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.github.ndex.messenger.demo_module.R
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.widget.LinearLayoutManager
import com.github.ndex.messenger.demo_module.presentation.chatlist.ChatListAdapter
import com.github.ndex.messenger.interfaces.ChatInfo


class ChatListActivity : AppCompatActivity() {
    private lateinit var chatList: RecyclerView
    private lateinit var chatViewModel: ChatListViewModel
    private lateinit var chatListAdapter: ChatListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_list)

        val chatListFactory = ChatListViewModelFactory()
        chatViewModel = ViewModelProviders.of(this, chatListFactory).get(ChatListViewModel::class.java)

        chatList = findViewById(R.id.chat_list)
        chatList.layoutManager = LinearLayoutManager(this)
        chatListAdapter = ChatListAdapter()
        chatList.adapter = chatListAdapter
        subscribeData()
    }

    private fun subscribeData() {
        chatViewModel.getChatList().observe(this, Observer<List<ChatInfo>> { newValue ->
            chatListAdapter.chatList = newValue!!
        })
    }
}