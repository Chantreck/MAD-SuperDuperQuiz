package com.chantreck.superduperquiz.ui.hub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.chantreck.superduperquiz.R
import com.chantreck.superduperquiz.databinding.ActivityHubBinding
import com.chantreck.superduperquiz.ui.categories.CategoriesFragment
import com.chantreck.superduperquiz.ui.profile.ProfileFragment
import com.chantreck.superduperquiz.ui.quiz_list.QuizListFragment
import com.chantreck.superduperquiz.ui.rating.RatingFragment

class HubActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHubBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setViews()
    }

    private fun setViews() {
        binding.menu.setOnItemSelectedListener {
            openFragment(it.itemId)
        }

        openFragment(R.id.menuQuiz)
    }

    private fun openFragment(itemId: Int): Boolean {
        var fragment: Fragment? = null

        when (itemId) {
            R.id.menuQuiz -> {
                fragment = QuizListFragment()
            }
            R.id.menuCategories -> {
                fragment = CategoriesFragment()
            }
            R.id.menuRating -> {
                fragment = RatingFragment()
            }
            R.id.menuProfile -> {
                fragment = ProfileFragment()
            }
        }

        fragment?.let {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(binding.fragmentContainerView.id, fragment)
            }
            return true
        }
        return false
    }
}