package com.ibermatica.pruebaandroid.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ibermatica.pruebaandroid.databinding.FragmentFeedsBinding
import kotlinx.android.synthetic.main.fragment_feeds.*


/**
 * A placeholder fragment containing a simple view.
 */
class ItemsActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val binding = DataBindingUtil.inflate<FragmentFeedsBinding>(inflater, com.ibermatica.pruebaandroid.R.layout.fragment_feeds, container, false)

        val viewModel = ViewModelProviders.of(this).get(ItemsListViewModel::class.java)

        binding.feedList.setHasFixedSize(true)
        binding.flNoResults.visibility = View.GONE


        viewModel.errorMessage.observe(this, Observer<Int> {
            errorMessage -> errorMessage?.let {
            configureErrorScreen(binding, errorMessage, viewModel)
        }
        })

        binding.viewModel = viewModel

        return binding.root//inflater.inflate(R.layout.fragment_feeds, container, false)
    }

    private fun configureErrorScreen(binding: FragmentFeedsBinding, errorMessage: Int, viewModel: ItemsListViewModel) {
        binding.tvNoResults.text = resources.getText(errorMessage)

        btRetry.setOnClickListener {
            flNoResults.visibility = View.GONE
            viewModel.loadItems()
            btRetry.setOnClickListener(null)
        }

        flNoResults.visibility = View.VISIBLE
    }

}
