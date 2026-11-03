package com.example.neptunus_daniss.message

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.neptunus_daniss.R
import com.example.neptunus_daniss.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = convertView?.let(ItemMessageBinding::bind)
            ?: ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)

        val data = messages[position]
        Glide.with(context)
            .load(data.avatarUrl)
            .placeholder(R.drawable.avatar_placeholder)
            .error(R.drawable.avatar_placeholder)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.w("MessageAdapter", "Gagal memuat avatar: ${data.avatarUrl}", e)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean = false
            })
            .into(binding.avatarImg)
        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText
        binding.textAge.text = data.age

        binding.root.setOnClickListener {
            Snackbar.make(
                parent,
                "Pesan dari ${data.senderName}: ${data.messageText}",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }
}
