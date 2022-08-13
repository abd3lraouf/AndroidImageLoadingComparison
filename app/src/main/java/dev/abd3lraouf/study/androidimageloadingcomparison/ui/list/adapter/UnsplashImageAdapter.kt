package dev.abd3lraouf.study.androidimageloadingcomparison.ui.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import dev.abd3lraouf.study.androidimageloadingcomparison.domain.model.UnsplashImage

class UnsplashImageAdapter : RecyclerView.Adapter<UnsplashViewHolder>() {
    var images: List<UnsplashImage> = UnsplashImage.makeFakeItems(10)
        set(value) {
            DiffUtil
                .calculateDiff(UnsplashDiffCallback(oldList = field, newList = value))
                .dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        UnsplashViewHolder.create(parent)

    override fun getItemCount() = images.size

    override fun onBindViewHolder(holder: UnsplashViewHolder, position: Int) {
        holder.bind(images[position])
    }
}
