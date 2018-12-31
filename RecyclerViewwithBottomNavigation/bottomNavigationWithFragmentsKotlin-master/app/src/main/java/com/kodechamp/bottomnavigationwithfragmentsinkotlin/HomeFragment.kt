package com.kodechamp.bottomnavigationwithfragmentsinkotlin

import com.kodechamp.bottomnavigationwithfragmentsinkotlin.data.PersonListAdapter
import com.kodechamp.bottomnavigationwithfragmentsinkotlin.model.Person
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.fragment_home.*
import org.json.JSONArray
import org.json.JSONException


class HomeFragment : Fragment() {

    private var adapter:PersonListAdapter?=null
    private var personList:ArrayList<Person>?=null
    private var layoutManager: RecyclerView.LayoutManager?=null


    var volleyRequest: RequestQueue?=null

    val testLink="https://api.github.com/users/hadley/repos"


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {


        volleyRequest= Volley.newRequestQueue(this.context)

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        personList=ArrayList<Person>()
        layoutManager= LinearLayoutManager(this.context)
        adapter= PersonListAdapter(personList,this.context!!)
        recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter
        val jsonArray=JsonArrayRequest(Request.Method.GET,testLink,
                Response.Listener {
                    response: JSONArray ->

                    try {
                        Log.d("Response from JSON",response.toString())

                        for(i in 0..response.length()-1)
                        {

                            val person = Person()

                            val testObj=response.getJSONObject(i)
                            var menu=testObj.getString("name")
person.name=menu
                            Log.d("Menu from JSON",menu)

                            var price:String=testObj.getString("id")
person.age=price.toDouble()
                            Log.d("Price from JSON",price)

                            personList!!.add(person)
                        }
                        adapter!!.notifyDataSetChanged()
                    } catch (e:JSONException){e.printStackTrace()}
                },

                Response.ErrorListener {
                    error ->

                    try {
                        Log.d("Error",error.toString())
                    }
                    catch (e: JSONException){e.printStackTrace()}
                })

        volleyRequest!!.add(jsonArray)
        return view
    }


}
