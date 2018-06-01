package com.github.ndex.messenger.demo_module.presentation.chat

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.ndex.messenger.demo_module.R

class ViewHolderFactory {
    fun createViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return when (viewType) {
            INPUT_MESSAGE_TYPE -> createInputMessage(parent)
            else -> createOutputMessage(parent)
        }
    }

    private fun createOutputMessage(parent: ViewGroup) =
            MessageViewHolder(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.output_message_item_layout, parent, false))


    private fun createInputMessage(parent: ViewGroup) =
            MessageViewHolder(LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.input_message_item_layout, parent, false))

}