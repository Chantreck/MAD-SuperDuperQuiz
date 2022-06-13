package com.chantreck.superduperquiz.ui.quiz_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.chantreck.superduperquiz.R
import com.chantreck.superduperquiz.domain.dto.Quiz
import com.chantreck.superduperquiz.databinding.FragmentQuizListBinding

class QuizListFragment : Fragment() {
    private lateinit var binding: FragmentQuizListBinding
    private val viewModel by viewModels<QuizListViewModel>()

    private val listener = object : QuizClickListener {
        override fun onClick(quiz: Quiz) {
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

        setObservers()
    }

    private fun setObservers() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            if (state.error != null) {
                Toast.makeText(activity, state.error, Toast.LENGTH_SHORT).show()
            }

            if (state.isListEmpty) {
                binding.quizListPlaceholder.root.isVisible = true
                binding.quizListRecycler.isVisible = false
            } else {
                binding.quizListPlaceholder.root.isVisible = false
                binding.quizListRecycler.isVisible = true
                adapter.submitList(state.list)
            }
        }
    }
}