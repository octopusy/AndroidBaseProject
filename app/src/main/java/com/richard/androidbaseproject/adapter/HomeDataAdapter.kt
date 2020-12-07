package com.richard.androidbaseproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.axl.android.frameworkbase.view.BaseRecyclerAdapter
import com.axl.android.frameworkbase.view.OnRecyclerViewItemClickListener
import com.richard.androidbaseproject.R
import com.richard.androidbaseproject.model.HomeData
import kotlinx.android.synthetic.main.listitem_home_news.view.*

/**
 * @project：AndroidBaseProject
 * @author：- richard on 2020/12/7 0007 11:37
 * @email：zhangyang5547662@126.com
 */
class HomeDataAdapter(): BaseRecyclerAdapter<HomeData, HomeDataAdapter.ViewHolder>() {

    private var listener: OnRecyclerViewItemClickListener<HomeData>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.listitem_home_news, parent, false))

    override fun setOnItemClickLitener(onItemClickLitener: OnRecyclerViewItemClickListener<HomeData>?) {
        super.setOnItemClickLitener(onItemClickLitener)
        listener = onItemClickLitener
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }

    inner class ViewHolder(holder: View) : RecyclerView.ViewHolder(holder) {

        val mContext: Context by lazy {
            itemView.context
        }

        fun bindData(data: HomeData) {
            itemView.tv_title.text = data.title
            itemView.tv_author.text = data.shareUser
            itemView.tv_date.text = data.shareDate
            itemView.setOnClickListener {
                if(null != listener) {
                    listener!!.onItemClick(itemView,data,position)
                }
            }
        }
    }
}