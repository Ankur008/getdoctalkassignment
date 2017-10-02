package itstym.work.getdoctalkassignment

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.user_item.view.*

/**
 * Created by itstym on 29/9/17.
 */


class adapter(var mcontext: Context, var users:ArrayList<Items>? ): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun getItemCount(): Int {
        Log.v("size is ",users?.size!!.toString())
        return users?.size!!

    }

    fun updateData(users: ArrayList<Items>?){
        this.users=users
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
