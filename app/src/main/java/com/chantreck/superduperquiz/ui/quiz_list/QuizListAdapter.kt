package com.chantreck.superduperquiz.ui.quiz_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.chantreck.superduperquiz.R
import com.chantreck.superduperquiz.data.QuizShortInfo
import com.chantreck.superduperquiz.databinding.ItemQuizBinding

class QuizListAdapter(private val listener: QuizClickListener) :
    ListAdapter<QuizShortInfo, QuizListAdapter.ViewHolder>(DIFF) {

    private companion object {
        val DIFF = object : DiffUtil.ItemCallback<QuizShortInfo>() {
            override fun areItemsTheSame(oldItem: QuizShortInfo, newItem: QuizShortInfo) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: QuizShortInfo, newItem: QuizShortInfo) =
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

        fun bind(item: QuizShortInfo) = with(binding) {
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