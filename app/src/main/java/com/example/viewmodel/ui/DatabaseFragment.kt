package com.example.viewmodel.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.viewmodel.R
import com.example.viewmodel.databinding.FragmentDatabaseBinding
import com.example.viewmodel.ui.viewModels.DatabaseViewModel
import com.opinyour.android.app.data.utils.Injection
import kotlinx.android.synthetic.main.fragment_database.*


class DatabaseFragment : Fragment() {
    private lateinit var databaseViewModel: DatabaseViewModel

    lateinit var binding: FragmentDatabaseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_database, container, true)
        binding.lifecycleOwner = this
        binding.databaseModel = databaseViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseViewModel =
            ViewModelProvider(this, Injection.provideViewModelFactory(requireContext()))
                .get(DatabaseViewModel::class.java)

        //TODO: 8. nahradit observer databindingom v xml
        databaseViewModel.words.observe(viewLifecycleOwner) { words_text.text = it.toString() }

        //TODO: 10. nahradit listener databindingom v xml
        word_btn.setOnClickListener { addWord() }
    }

    //TODO: 10. odstanit funkciu pomocou databindingu v xml
    private fun addWord() {
        val word = word_input.text.toString()
        if (word.isNotEmpty()) {
            databaseViewModel.insertWord(word)
            word_input.text.clear()
        }
    }
}
