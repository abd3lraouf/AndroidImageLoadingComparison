package dev.abd3lraouf.study.androidimageloadingcomparison.ui.list.adapter

import androidx.recyclerview.widget.DiffUtil
import dev.abd3lraouf.study.androidimageloadingcomparison.domain.model.UnsplashImage

class UnsplashDiffCallback(
    private val oldList: List<UnsplashImage>,
    private val newList: List<UnsplashImage>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        if (oldItem.id != newItem.id) return false
        return true
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        if (oldItem.id != newItem.id) return false
        if (oldItem.author != newItem.author) return false
        if (oldItem.url != newItem.url) return false
        return true
    }
}
