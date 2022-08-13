package dev.abd3lraouf.study.androidimageloadingcomparison.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dev.abd3lraouf.study.androidimageloadingcomparison.databinding.ListItemUnsplashBinding
import dev.abd3lraouf.study.androidimageloadingcomparison.domain.model.UnsplashImage

class UnsplashViewHolder(private val binding: ListItemUnsplashBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(unsplashImage: UnsplashImage) {
        showData(UnsplashImage.Empty)

        val callback = object : Callback {
            override fun onSuccess() = showData(unsplashImage)
            override fun onError(e: Exception?) = showData(unsplashImage)
        }
        Picasso.get()
            .load(unsplashImage.url)
            .fit()
            .centerCrop()
            .into(binding.image, callback)
    }

    private fun showData(unsplashImage: UnsplashImage) {
        val isPlaceholder = unsplashImage == UnsplashImage.Empty
        binding.placeholder.isVisible = isPlaceholder
        binding.content.isInvisible = isPlaceholder
        binding.author.text = unsplashImage.author
        binding.image.contentDescription = unsplashImage.author
    }

    companion object {
        fun create(parent: ViewGroup): UnsplashViewHolder {
            val binding =
                ListItemUnsplashBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return UnsplashViewHolder(binding)
        }
    }
}
