package com.example.pucferias.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.pucferias.R
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private val mainViewModel by inject<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        setupViewModelObservers()
    }

    private fun setupListeners() {
        button_add.setOnClickListener {
            mainViewModel.addNumber()
        }
    }

    private fun setupViewModelObservers() {
        mainViewModel.isNumberOdd.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer
            when (it) {
                MainViewModel.NumberState.SUCCESS -> {
                    setViewSuccessState()
                }
                MainViewModel.NumberState.ERROR -> {
                    setViewErrorState()
                }
                MainViewModel.NumberState.LOADING -> {
                    setViewLoadingState()
                }
            }
        })

        mainViewModel.numberValue.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer
            textView_contagem.text = mainViewModel.number.toString()
        })
    }

    private fun setViewSuccessState() {
        textView_observando.visibility = View.VISIBLE
        textView_observando.text = "O numero é par!"
    }

    private fun setViewLoadingState() {
        textView_observando.visibility = View.VISIBLE
        textView_observando.text = "carregando..."
    }

    private fun setViewErrorState() {
        textView_observando.visibility = View.GONE
    }

}
