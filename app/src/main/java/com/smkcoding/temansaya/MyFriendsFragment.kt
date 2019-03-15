package com.smkcoding.temansaya

//import android.app.Fragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.my_friends_fragment.*
//import androidx.fragment.app.Fragment

class MyFriendsFragment : Fragment() {

    lateinit var listTeman : MutableList<MyFriend>

    companion object {
        fun newInstance(): MyFriendsFragment {
            return MyFriendsFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.my_friends_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        fabAddFriend.setOnClickListener { (activity as MainActivity).tampilMyFriendsAddFragment() }

        simulasiDataTeman()
        tampilTeman()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

    //==========================================
    private fun simulasiDataTeman() {
        listTeman = ArrayList()

        listTeman.add(MyFriend("Muhammad", "Laki-laki", "ade@gmail.com", "085719004268", "Bandung"))
        listTeman.add(MyFriend("Al Harits", "Laki-laki", "rifaldi@gmail.com", "081213416171", "Bandung"))
    }

    private fun tampilTeman() {
        listMyFriends.layoutManager = LinearLayoutManager(activity)
        listMyFriends.adapter = MyFriendAdapter(activity!!, listTeman)
    }

}