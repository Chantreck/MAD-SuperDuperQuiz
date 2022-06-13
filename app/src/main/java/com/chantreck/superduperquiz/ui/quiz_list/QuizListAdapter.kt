package com.chantreck.superduperquiz.ui.quiz_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chantreck.superduperquiz.R
import com.chantreck.superduperquiz.domain.dto.Quiz
import com.chantreck.superduperquiz.databinding.ItemQuizBinding

class QuizListAdapter(private val listener: QuizClickListener) :
    ListAdapter<Quiz, QuizListAdapter.ViewHolder>(DIFF) {

    private companion object {
        val DIFF = object : DiffUtil.ItemCallback<Quiz>() {
            override fun areItemsTheSame(oldItem: Quiz, newItem: Quiz) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Quiz, newItem: Quiz) =
                oldItem == newItem
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemQuizBinding.bind(view)

        init {
            binding.root.setOnClickListener {
                listener.onClick(getItem(layoutPosition))
            }
        }

        fun bind(item: Quiz) = with(binding) {
            quizCardTitle.text = item.title
            quizCardDescription.text = item.description
            quizCardInfo.text = "${item.category} • ${item.difficulty}"
            quizCardAuthor.text = item.authorNickname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quiz, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}