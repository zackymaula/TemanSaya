package com.smkcoding.temansaya

//import android.app.Fragment
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.my_friends_fragment.*
//import androidx.fragment.app.Fragment

class MyFriendsFragment : Fragment() {

    //lateinit var listTeman : MutableList<MyFriend>

    companion object {
        fun newInstance(): MyFriendsFragment {
            return MyFriendsFragment()
        }
    }

    private var listTeman : List<MyFriend>? = null

    private var db: AppDatabase? = null
    private var myFriendDao: MyFriendDao? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.my_friends_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(activity!!)
        myFriendDao = db?.myFriendDao()
    }

    private fun initView() {
        fabAddFriend.setOnClickListener { (activity as MainActivity).tampilMyFriendsAddFragment() }

        ambilDataTeman()
    }

    private fun ambilDataTeman() {

        listTeman = ArrayList()
        myFriendDao?.ambilSemuaTeman()?.observe(this, Observer { r ->

            listTeman = r

            when {
                listTeman?.size == 0 -> tampilToast("Belum ada data teman")

                else -> {
                    tampilTeman()
                }

            }

        })

    }

    private fun tampilToast(message: String) {
        Toast.makeText(activity!!, message, Toast.LENGTH_SHORT).show()
    }

    private fun tampilTeman() {
        listMyFriends.layoutManager = LinearLayoutManager(activity)
        listMyFriends.adapter = MyFriendAdapter(activity!!, listTeman!!)
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

    //==========================================
    /*private fun simulasiDataTeman() {
        listTeman = ArrayList()

        listTeman.add(MyFriend("Muhammad", "Laki-laki", "ade@gmail.com", "085719004268", "Bandung"))
        listTeman.add(MyFriend("Al Harits", "Laki-laki", "rifaldi@gmail.com", "081213416171", "Bandung"))
    }*/


}