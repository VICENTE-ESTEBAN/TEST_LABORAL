package com.ibermatica.pruebaandroid.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ibermatica.pruebaandroid.R
import com.ibermatica.pruebaandroid.injection.MyViewModelFactory
import kotlinx.android.synthetic.main.fragment_new.*

/**
 * A placeholder fragment containing a simple view.
 */
class NewActivityFragment : Fragment() {

    var model: NewActivityFragmentViewModel? = null

    companion object {

        fun newInstance(): NewActivityFragment {
            return NewActivityFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_new, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rbSum.setOnClickListener{
            calculate(it.id)
        }

        rbDifference.setOnClickListener{
            calculate(it.id)
        }

        rbMultiply.setOnClickListener{
            calculate(it.id)
        }

        rbDivide.setOnClickListener{
            calculate(it.id)
        }

        model?.selected?.observe(this, Observer<String> { item ->
            showResult(item)
        })

        rbSum.isChecked = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model = activity?.run {ViewModelProviders.of(
                this,
                MyViewModelFactory(activity?.application!!)).get(NewActivityFragmentViewModel::class.java)}

    }

    private fun calculate(checkedId: Int) {

        var operation: NewActivityFragmentViewModel.Operation? = null
        when (checkedId) {
            R.id.rbSum -> operation = NewActivityFragmentViewModel.Operation.SUM
            R.id.rbDifference -> operation = NewActivityFragmentViewModel.Operation.DIFFERENCE
            R.id.rbMultiply -> operation = NewActivityFragmentViewModel.Operation.MULTIPLY
            R.id.rbDivide -> operation = NewActivityFragmentViewModel.Operation.DIVIDE
        }

        operation?.run {
            if (TextUtils.isEmpty(etNumber1.text.toString()))
                etNumber1.setText("0")

            if (TextUtils.isEmpty(etNumber2.text.toString()))
                etNumber2.setText("0")

            model?.calculate(
                    operation,
                    etNumber1.text.toString(),
                    etNumber2.text.toString()) }

    }

    fun showResult(result:String?)
    {
        tvResultado.text = result
    }

}
