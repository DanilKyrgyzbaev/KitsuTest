package common

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.geekstudio.kitsutest.core_ui.databinding.AnimeItemBinding
import model.AnimeData

class AnimeAdapter(private val anime: ArrayList<AnimeData>, private val context: Context): RecyclerView.Adapter<AnimeViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(data: List<AnimeData>) {
        anime.clear()
        anime.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = AnimeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val URL = anime.get(0).attributes.posterImage.medium
        Glide
            .with(context)
            .load("$URL")
            .centerCrop()
            .into(holder.binding.imAnime)
    }

    override fun getItemCount(): Int {
        return anime.size
    }
}

class AnimeViewHolder(val binding: AnimeItemBinding): RecyclerView.ViewHolder(binding.root)