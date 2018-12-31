package com.kodechamp.bottomnavigationwithfragmentsinkotlin.data

import android.content.Context
import android.content.Intent
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.kodechamp.bottomnavigationwithfragmentsinkotlin.HomeFragment
import com.kodechamp.bottomnavigationwithfragmentsinkotlin.MapFragment
import com.kodechamp.bottomnavigationwithfragmentsinkotlin.R
import com.kodechamp.bottomnavigationwithfragmentsinkotlin.R.id.itemimage
import com.kodechamp.bottomnavigationwithfragmentsinkotlin.model.Person
import com.squareup.picasso.Picasso

class PersonListAdapter(private val list: ArrayList<Person>?, private val context: Context): RecyclerView.Adapter<PersonListAdapter.ViewHolder>()
{
    override fun getItemCount(): Int {
        return list!!.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.list_row,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.bindItem(list?.get(p1))
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        fun bindItem(person: Person?)
        {
            var name: TextView =itemView.findViewById(R.id.name) as TextView
            var age: TextView =itemView.findViewById(R.id.age) as TextView
            name.text=person!!.name
            age.text = person.age.toString()
        }

init {
    itemView.setOnClickListener {
    }
}
    }
}