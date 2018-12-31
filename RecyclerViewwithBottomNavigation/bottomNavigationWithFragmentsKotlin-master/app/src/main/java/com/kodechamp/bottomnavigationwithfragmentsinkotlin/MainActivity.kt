package com.kodechamp.bottomnavigationwithfragmentsinkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import com.kodechamp.bottomnavigationwithfragmentsinkotlin.data.PersonListAdapter
import com.kodechamp.bottomnavigationwithfragmentsinkotlin.model.Person

class MainActivity : AppCompatActivity() {

    private var adapter:PersonListAdapter?=null
    private var personList:ArrayList<Person>?=null
    private var layoutManager: RecyclerView.LayoutManager?=null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {item->
        when(item.itemId){
            R.id.home -> {
                println("home pressed")
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.map -> {
                println("map pressed")
                replaceFragment(MapFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.cart -> {
                println("cart pressed")
                replaceFragment(CartFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        
        false

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(HomeFragment())


    }


    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
