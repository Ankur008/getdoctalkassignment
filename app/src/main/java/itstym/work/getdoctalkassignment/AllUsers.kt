package itstym.work.getdoctalkassignment

import android.content.Context
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by itstym on 29/9/17.
 */


data class AllUsers(val context:Context){

    @SerializedName("total_count")
    @Expose
    public var totalCount: Int? = null
    @SerializedName("incomplete_results")
    @Expose
    public var incompleteResults: Boolean? = null
    @SerializedName("items")
    @Expose
    public var items: ArrayList<Items>? = null

}