package com.example.retrofit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.retrofit.api.ApiFile
import com.example.retrofit.api.ResultApi
import com.example.retrofit.databinding.FragmentStartBinding
import com.example.retrofit.repository.MainRepository
import com.example.retrofit.viewmodel.MainViewModel
import com.example.retrofit.viewmodel.MainViewModelFactory

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var mainViewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val resultApi = ApiFile.getInstance().create(ResultApi::class.java)
        val mainRepository = MainRepository(resultApi)

        mainViewModel = ViewModelProvider(
            this,
            MainViewModelFactory(mainRepository)
        )[MainViewModel::class.java]

        mainViewModel.result.observe(viewLifecycleOwner) {
            binding.textUsername.text = it.results[0].login.username
            binding.textFirst.text = it.results[0].name.first
            binding.textLast.text = it.results[0].name.last
            binding.gender.text = it.results[0].gender
            binding.country.text = it.results[0].location.country
            binding.city.text = it.results[0].location.city
            binding.phone.text = it.results[0].phone
            binding.email.text = it.results[0].email

            Glide.with(this@StartFragment)
                .load(it.results[0].picture.large)
                .into(binding.image)

        }
        binding.button.setOnClickListener {

        }
    }

}



