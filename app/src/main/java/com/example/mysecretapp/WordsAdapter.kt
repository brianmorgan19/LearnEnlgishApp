package com.example.mysecretapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mysecretapp.databinding.WordLayoutBinding
import kotlinx.android.synthetic.main.word_layout.view.*

class WordsAdapter(
    var words: List<Word>
) : RecyclerView.Adapter<WordsAdapter.WordHolder>() {

    inner class WordHolder(itemView: View): RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.word_layout, parent, false)
        return  WordHolder(view)
    }

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        holder.itemView.apply {
            val word = words[position]
            title228.text = word.title
            checkBox.isChecked = word.completed
        }
    }

    override fun getItemCount(): Int {
        return words.size
    }


}