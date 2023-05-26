package kg.geekstudio.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import base.BaseFragment
import common.AnimeAdapter
import kg.geekstudio.kitsutest.main.databinding.FragmentHomeBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel
import state.UIState

@ExperimentalCoroutinesApi
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private lateinit var adapter: AnimeAdapter
    override val viewModel by viewModel<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchAnime()
    }

    override fun initialize() {
        adapter = AnimeAdapter(ArrayList(), requireContext())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun setupObservers() {
        viewModel.animeList.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is UIState.Success ->{
                    val animeDataList = uiState.data
                    adapter.updateData(animeDataList)
                    adapter.notifyDataSetChanged()
                }
                is UIState.Error ->{
                    val errorMessage = uiState.error
                }
                is UIState.Loading -> {
                    // Обработка состояния загрузки
                }
            }
        }
    }
}