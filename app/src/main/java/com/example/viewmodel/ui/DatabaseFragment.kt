package com.example.viewmodel.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_database, container, false
        )
        binding.lifecycleOwner = this
        databaseViewModel =
            ViewModelProvider(this, Injection.provideViewModelFactory(requireContext()))
                .get(DatabaseViewModel::class.java)

        binding.databaseModel = databaseViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseViewModel =
            ViewModelProvider(this, Injection.provideViewModelFactory(requireContext()))
                .get(DatabaseViewModel::class.java)
    }
}
