package com.example.viewmodel.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.viewmodel.R
import com.example.viewmodel.ui.viewModels.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

        //TODO: 1. prerobit na databinding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO: 2. nahradit observer databindingom v xml
        homeViewModel.word.observe(viewLifecycleOwner) { words_text.text = it }

        //TODO: 5. nahradit listener databindingom v xml
        word_btn.setOnClickListener { changeWord() }

        //TODO: 6. umoznit navigaciu do DatabaseFragmentu po stlaceni tlacidla
    }

    //TODO: 5. odstanit funkciu pomocou databindingu v xml
    private fun changeWord() {
        val word = word_input.text.toString()
        if (word.isNotEmpty()) {
            homeViewModel.changeWord(word)
            word_input.text.clear()
        }
    }
}
