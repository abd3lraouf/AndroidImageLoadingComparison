package dev.abd3lraouf.study.androidimageloadingcomparison.ui.list.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.target.DrawableImageViewTarget
import com.bumptech.glide.request.transition.Transition
import dev.abd3lraouf.study.androidimageloadingcomparison.databinding.ListItemUnsplashBinding
import dev.abd3lraouf.study.androidimageloadingcomparison.domain.model.UnsplashImage
import dev.abd3lraouf.study.androidimageloadingcomparison.ui.core.glide.GlideApp

class UnsplashViewHolder(private val binding: ListItemUnsplashBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(unsplashImage: UnsplashImage) {
        showData(UnsplashImage.Empty)

        if (unsplashImage == UnsplashImage.Empty) {
            showData(UnsplashImage.Empty)
            return
        }

        val callback = object : DrawableImageViewTarget(binding.image) {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                super.onResourceReady(resource, transition)
                showData(unsplashImage)
            }
        }
        GlideApp.with(itemView)
            .asDrawable()
            .load(unsplashImage.url.toUri())
            .centerCrop()
            .into(callback)
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
