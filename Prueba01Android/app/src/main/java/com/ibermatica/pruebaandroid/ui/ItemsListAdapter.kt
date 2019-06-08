package com.ibermatica.pruebaandroid.ui

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.text.method.ScrollingMovementMethod
import android.view.*
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.ibermatica.pruebaandroid.R
import com.ibermatica.pruebaandroid.model.Item


class ItemsListAdapter: RecyclerView.Adapter<ItemsListAdapter.ViewHolder>() {
    private var itemList:ArrayList<Item>? = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsListAdapter.ViewHolder {
        val binding: com.ibermatica.pruebaandroid.databinding.ItemFeedBinding =
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.item_feed,
                        parent,
                        false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemsListAdapter.ViewHolder, position: Int) {
        itemList?.get(position)?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return  itemList?.size?: 0
    }

    fun updatePostList(newList:List<Item>?){

        this.itemList?.clear()

        newList?.let { this.itemList?.addAll(ArrayList(newList))}


        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: com.ibermatica.pruebaandroid.databinding.ItemFeedBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel = ItemViewModel()

        fun bind(item:Item){
            viewModel.bind(item)
            binding.viewModel = viewModel


            if (item.categories is List<String>) {

                val builder = StringBuilder()

                for (category: String in item.categories!!) {
                    builder.append(category)
                    builder.append("\n")
                    builder.append("\n")
                }

                binding.itemTitle.setOnClickListener{

                    showPopUp(it, builder.toString())
                }
            }



        }

        fun showPopUp(view: View,  text_categories: String){
            // inflate the layout of the popup window
            val popupView = LayoutInflater.from(view.context).inflate(R.layout.item_feed_popup, null, false)


            val tvcategories = popupView.findViewById<TextView>(R.id.tvcategories)
            tvcategories.setMovementMethod(ScrollingMovementMethod())
            tvcategories.text = text_categories

            // create the popup window
            val width = LinearLayout.LayoutParams.MATCH_PARENT
            val height = LinearLayout.LayoutParams.MATCH_PARENT
            val focusable = true // lets taps outside the popup also dismiss it
            val popupWindow = PopupWindow(popupView, width, height, focusable)

            // show the popup window
            // which view you pass in doesn't matter, it is only used for the window tolken
            popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)

            // dismiss the popup window when touched
            popupView.setOnTouchListener { _, event ->
                if(!touchWithinBounds(event, tvcategories) ){
                    popupWindow.dismiss()
                }
                true
            }


        }

        fun touchWithinBounds(event: MotionEvent?, view: View?): Boolean {
            if (event == null || view == null || view.width === 0 || view.height === 0)
                return false

            val viewLocation = IntArray(2)
            view.getLocationOnScreen(viewLocation)
            val viewMaxX = viewLocation[0] + view.width - 1
            val viewMaxY = viewLocation[1] + view.height - 1
            return (event.rawX <= viewMaxX && event.rawX >= viewLocation[0]
                    && event.rawY <= viewMaxY && event.rawY >= viewLocation[1])
        }
    }



}