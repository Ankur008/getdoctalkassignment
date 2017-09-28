package itstym.work.getdoctalkassignment

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.user_item.view.*

/**
 * Created by itstym on 29/9/17.
 */


class adapter(var mcontext: Context, var users:ArrayList<Items>? ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val blogPost=1
    val blogLoadMore=2;

    override fun getItemViewType(position: Int): Int {

        if (position<itemCount-1){
            return blogPost
        }else{
            return blogLoadMore
        }
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return users?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        // Log.i("Adaptor viewtype ", Integer.toString(viewType))
        val v = LayoutInflater.from(mcontext).inflate(R.layout.user_item, parent, false)
        return Item(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        (holder as Item).itemView.name.text = users!![position].login
    }


    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
