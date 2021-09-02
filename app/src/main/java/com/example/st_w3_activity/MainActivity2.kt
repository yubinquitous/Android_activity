package com.example.st_w3_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity2 : AppCompatActivity() {
    var tabNames = listOf("투두", "프로필", "베스트셀러")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tabLayout: TabLayout = findViewById(R.id.main2_tabs)
        var nameTv : String? = null

        intent?.let {
            it.getStringExtra("user-name")?.let { name ->
                nameTv = name
            }
        }
//        intent.let {
//            val isDark: Boolean = intent.getBooleanExtra("theme-mode", false)
//            if (isDark) {
//                tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.darkgray))
//                tabLayout.setTabTextColors(Color.rgb(255, 255, 255), Color.rgb(242, 208, 108))
//            } else {
//                tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
//                tabLayout.setTabTextColors(Color.rgb(9, 9, 9), Color.rgb(242, 208, 108))
//            }
//        }

        val pagerAdapter = MainPagerAdapter(this)
        pagerAdapter.addFragment(TodayFragment())
        pagerAdapter.addFragment(FriendFragment())
        pagerAdapter.addFragment(BookFragment())

        val viewPager: ViewPager2 = findViewById(R.id.main2_viewpager)
        viewPager.adapter = pagerAdapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabNames[position]
        }.attach()
    }
}