package com.example.st_w3_activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FriendFragment :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_friend, container, false)
        initRecyclerView(view)

        return view
    }

    private fun initRecyclerView(view: View){
        val recyclerView = view.findViewById<RecyclerView>(R.id.friend_recyclerview)
        val lm = LinearLayoutManager(requireActivity())
        val rvAdapter = FriendRvAdapter(requireActivity())

        recyclerView.layoutManager = lm
        rvAdapter.addItems(createDummy())

        recyclerView.adapter = rvAdapter
    }

    fun createDummy() : ArrayList<Friend>{
        val items = ArrayList<Friend>()

        items.add(Friend("https://i.pinimg.com/564x/79/2a/b9/792ab9d9c0312b21912e91d9e09deef7.jpg", "바넬로피", "주먹왕랄프", "Owl City"))
        items.add(Friend("https://i.pinimg.com/236x/16/0e/90/160e90ad6aded4c8d8ca4510b207ad20.jpg", "주디", "주토피아", "Try Everything"))
        items.add(Friend("https://i.pinimg.com/236x/b4/7c/3e/b47c3e30e0fd89494b3f7b63e3af1fe6.jpg", "포뇨", "벼랑 위의 포뇨", "崖の上のポニョ"))
        items.add(Friend("https://i.pinimg.com/236x/74/87/ad/7487ade70b50f76d44540d2fe1faf885.jpg", "소스케", "벼랑 위의 포뇨", "히사이시 조"))
        items.add(Friend("https://i.pinimg.com/236x/c0/ef/17/c0ef1718a2b0e68a43ddaf262272228c.jpg", "치히로", "센과 치히로의 행방불명", "いつも何度でも"))
        items.add(Friend("https://i.pinimg.com/564x/79/2a/b9/792ab9d9c0312b21912e91d9e09deef7.jpg", "바넬로피", "주먹왕랄프", "Owl City"))
        items.add(Friend("https://i.pinimg.com/236x/16/0e/90/160e90ad6aded4c8d8ca4510b207ad20.jpg", "주디", "주토피아", "Try Everything"))
        items.add(Friend("https://i.pinimg.com/236x/b4/7c/3e/b47c3e30e0fd89494b3f7b63e3af1fe6.jpg", "포뇨", "벼랑 위의 포뇨", "崖の上のポニョ"))
        items.add(Friend("https://i.pinimg.com/236x/74/87/ad/7487ade70b50f76d44540d2fe1faf885.jpg", "소스케", "벼랑 위의 포뇨", "히사이시 조"))
        items.add(Friend("https://i.pinimg.com/236x/c0/ef/17/c0ef1718a2b0e68a43ddaf262272228c.jpg", "치히로", "센과 치히로의 행방불명", "いつも何度でも"))
        items.add(Friend("https://i.pinimg.com/564x/79/2a/b9/792ab9d9c0312b21912e91d9e09deef7.jpg", "바넬로피", "주먹왕랄프", "Owl City"))
        items.add(Friend("https://i.pinimg.com/236x/16/0e/90/160e90ad6aded4c8d8ca4510b207ad20.jpg", "주디", "주토피아", "Try Everything"))
        items.add(Friend("https://i.pinimg.com/236x/b4/7c/3e/b47c3e30e0fd89494b3f7b63e3af1fe6.jpg", "포뇨", "벼랑 위의 포뇨", "崖の上のポニョ"))
        items.add(Friend("https://i.pinimg.com/236x/74/87/ad/7487ade70b50f76d44540d2fe1faf885.jpg", "소스케", "벼랑 위의 포뇨", "히사이시 조"))
        items.add(Friend("https://i.pinimg.com/236x/c0/ef/17/c0ef1718a2b0e68a43ddaf262272228c.jpg", "치히로", "센과 치히로의 행방불명", "いつも何度でも"))
        items.add(Friend("https://i.pinimg.com/564x/79/2a/b9/792ab9d9c0312b21912e91d9e09deef7.jpg", "바넬로피", "주먹왕랄프", "Owl City"))
        items.add(Friend("https://i.pinimg.com/236x/16/0e/90/160e90ad6aded4c8d8ca4510b207ad20.jpg", "주디", "주토피아", "Try Everything"))
        items.add(Friend("https://i.pinimg.com/236x/b4/7c/3e/b47c3e30e0fd89494b3f7b63e3af1fe6.jpg", "포뇨", "벼랑 위의 포뇨", "崖の上のポニョ"))
        items.add(Friend("https://i.pinimg.com/236x/74/87/ad/7487ade70b50f76d44540d2fe1faf885.jpg", "소스케", "벼랑 위의 포뇨", "히사이시 조"))
        items.add(Friend("https://i.pinimg.com/236x/c0/ef/17/c0ef1718a2b0e68a43ddaf262272228c.jpg", "치히로", "센과 치히로의 행방불명", "いつも何度でも"))
        return items
    }
}