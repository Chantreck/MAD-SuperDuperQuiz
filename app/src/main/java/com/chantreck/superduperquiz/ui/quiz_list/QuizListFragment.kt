package com.chantreck.superduperquiz.ui.quiz_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.chantreck.superduperquiz.R
import com.chantreck.superduperquiz.data.QuizShortInfo
import com.chantreck.superduperquiz.databinding.FragmentQuizListBinding

class QuizListFragment : Fragment() {
    private lateinit var binding: FragmentQuizListBinding
    private val viewModel by viewModels<QuizListViewModel>()

    private val listener = object : QuizClickListener {
        override fun onClick(quiz: QuizShortInfo) {
            //TODO("Not yet implemented")
        }
    }
    private val adapter = QuizListAdapter(listener)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentQuizListBinding.bind(view)

        with(binding.quizListToolbar.toolbar) {
            setTitle(R.string.toolbar_quiz_list)
            inflateMenu(R.menu.menu_add)
        }

        binding.quizListRecycler.adapter = adapter
        binding.quizListRecycler.addItemDecoration(QuizListDecorator())
        mockRecycler()
    }

    private fun mockRecycler() {
        val list = List(5) { index ->
            QuizShortInfo(
                index.toString(),
                "Викторина по Смешарикам",
                "Викторина на знание лучшего детского мультфильма в истории человечества Смешариков!",
                "мультфильмы",
                "средняя",
                "Владислав Нетаев"
            )
        }

        adapter.submitList(list)
    }
}