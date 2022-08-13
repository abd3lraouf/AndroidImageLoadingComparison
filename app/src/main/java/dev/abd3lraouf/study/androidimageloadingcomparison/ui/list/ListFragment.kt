package dev.abd3lraouf.study.androidimageloadingcomparison.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.abd3lraouf.study.androidimageloadingcomparison.R
import dev.abd3lraouf.study.androidimageloadingcomparison.databinding.FragmentListBinding
import dev.abd3lraouf.study.androidimageloadingcomparison.ui.list.adapter.DividerItemDecorator
import dev.abd3lraouf.study.androidimageloadingcomparison.ui.list.adapter.UnsplashImageAdapter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val unsplashImageAdapter = UnsplashImageAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.unsplashImages.apply {
            val divider = ContextCompat.getDrawable(context, R.drawable.divider)
                .apply { this?.alpha = 32 }
            addItemDecoration(DividerItemDecorator(divider))
            adapter = unsplashImageAdapter
            layoutManager = LinearLayoutManager(context)
        }
        binding.swipeToRefresh.setOnRefreshListener { viewModel.fetchData() }
        viewModel.fetchData()
        viewModel.uiState
            .onEach { it.render() }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun UnsplashImagesUiState.render() {
        when (this) {
            is UnsplashImagesUiState.IDLE -> Unit
            UnsplashImagesUiState.Loading -> {
                binding.swipeToRefresh.isRefreshing = true
            }
            is UnsplashImagesUiState.Success -> {
                unsplashImageAdapter.images = data
                binding.swipeToRefresh.isRefreshing = false
            }
            is UnsplashImagesUiState.Error -> {
                Toast.makeText(requireContext(), "Error: $errorMessage", Toast.LENGTH_SHORT).show()
                binding.swipeToRefresh.isRefreshing = false
            }
        }
    }
}
