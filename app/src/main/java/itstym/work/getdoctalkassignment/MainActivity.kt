package itstym.work.getdoctalkassignment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.VolleyLog
import com.android.volley.toolbox.StringRequest
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*







//https://api.github.com/search/users?q=rm+sort:followers
//https://api.github.com/search/users?q=rm+sort:followerspage=1&per_page=10

class MainActivity : AppCompatActivity() {

    companion object {

        val TAG="Main Activity"
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun afterTextChanged(s: Editable) {

                Log.v("Text is ",s.toString());

                val url="https://api.github.com/search/users?q="+s.toString().trim()+"+sort:followers"
                fetchData(url)
            }
        })
    }

    private fun  fetchData(url: String) {



        val tag_string_req = "string_req"


        val strReq = StringRequest(Request.Method.GET,
                url, Response.Listener<String> {

                        response ->
                                Log.d(TAG, response.toString())

            val builder = GsonBuilder()

            val gson = builder.create()

            var allItems=gson.fromJson(response,AllUsers::class.java)

            Log.v("No of users",allItems.items?.size.toString())

            resultRecyclerView.setHasFixedSize(true)
            resultRecyclerView.layoutManager=LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
            resultRecyclerView.adapter=adapter(this@MainActivity,allItems.items)


        }, Response.ErrorListener { error ->

            VolleyLog.d(TAG, "Error: " + error.message)

        })

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req)
    }
}
