package com.smkcoding.temansaya

//import android.app.Fragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.my_friends_add_fragment.*

//import androidx.fragment.app.Fragment

class MyFriendsAddFragment : Fragment() {

    companion object {
        fun newInstance(): MyFriendsAddFragment {
            return MyFriendsAddFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.my_friends_add_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        btnSave.setOnClickListener { (activity as MainActivity).tampilMyFriendsFragment() }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}