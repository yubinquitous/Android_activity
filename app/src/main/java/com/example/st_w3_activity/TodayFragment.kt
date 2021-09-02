package com.example.st_w3_activity

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import org.w3c.dom.Text

class TodayFragment : Fragment() {
    private var isDark = false;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_today, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val themeBtn: Button = view.findViewById(R.id.today_theme_bt)
        val nextBtn: Button = view.findViewById(R.id.today_next_bt)

//        nameTv.text = arguments?.getString("user-name")

        themeBtn.setOnClickListener {
            val parent: ConstraintLayout = view.findViewById(R.id.today_parent_layout)
            val todoTv: TextView = view.findViewById(R.id.today_todo_tv)
            val cb1: CheckBox = view.findViewById(R.id.today_cb1_cb)
            val cb2: CheckBox = view.findViewById(R.id.today_cb2_cb)
            val cb3: CheckBox = view.findViewById(R.id.today_cb3_cb)
            val cb4: CheckBox = view.findViewById(R.id.today_cb4_cb)
            val cb5: CheckBox = view.findViewById(R.id.today_cb5_cb)
            val cb6: CheckBox = view.findViewById(R.id.today_cb6_cb)
            val nameTv: TextView = view.findViewById(R.id.today_name_tv)
            if (isDark) {
                parent.setBackgroundColor(ContextCompat.getColor(view.context, R.color.white))
                nameTv.setTextColor(ContextCompat.getColor(view.context, R.color.darkgray))
                todoTv.setTextColor(ContextCompat.getColor(view.context, R.color.darkgray))
                cb1.setTextColor(ContextCompat.getColor(view.context, R.color.darkgray))
                cb2.setTextColor(ContextCompat.getColor(view.context, R.color.darkgray))
                cb3.setTextColor(ContextCompat.getColor(view.context, R.color.darkgray))
                cb4.setTextColor(ContextCompat.getColor(view.context, R.color.darkgray))
                cb5.setTextColor(ContextCompat.getColor(view.context, R.color.darkgray))
                cb6.setTextColor(ContextCompat.getColor(view.context, R.color.darkgray))

                themeBtn.text = "DARK"
                isDark = false
            } else {
                parent.setBackgroundColor(ContextCompat.getColor(view.context, R.color.darkgray))
                nameTv.setTextColor(ContextCompat.getColor(view.context, R.color.dark_yellow))
                todoTv.setTextColor(ContextCompat.getColor(view.context, R.color.dark_yellow))
                cb1.setTextColor(ContextCompat.getColor(view.context, R.color.dark_yellow))
                cb2.setTextColor(ContextCompat.getColor(view.context, R.color.dark_yellow))
                cb3.setTextColor(ContextCompat.getColor(view.context, R.color.dark_yellow))
                cb4.setTextColor(ContextCompat.getColor(view.context, R.color.dark_yellow))
                cb5.setTextColor(ContextCompat.getColor(view.context, R.color.dark_yellow))
                cb6.setTextColor(ContextCompat.getColor(view.context, R.color.dark_yellow))

                themeBtn.text = "LIGHT"
                isDark = true
            }

//            val intent = Intent(view.context, MainActivity2::class.java)
//            intent.putExtra("theme-mode", isDark)
//            startActivity(intent)
        }

        nextBtn.setOnClickListener {
            val cb1: CheckBox = view.findViewById(R.id.today_cb1_cb)
            val cb2: CheckBox = view.findViewById(R.id.today_cb2_cb)
            val cb3: CheckBox = view.findViewById(R.id.today_cb3_cb)
            val cb4: CheckBox = view.findViewById(R.id.today_cb4_cb)
            val cb5: CheckBox = view.findViewById(R.id.today_cb5_cb)
            val cb6: CheckBox = view.findViewById(R.id.today_cb6_cb)
            val nameTv: TextView = view.findViewById(R.id.today_name_tv)
            if ((cb1.isChecked) && (cb2.isChecked) && (cb3.isChecked) && (cb4.isChecked) && (cb5.isChecked) && (cb6.isChecked))  {
                val intent = Intent(view.context, NightActivity::class.java)
                intent.putExtra("user-name", nameTv.text)
                startActivity(intent)
            } else {

                val toast  = Toast.makeText(view.context, "할 일을 마쳐주세요!", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 850 )
                toast.show()
            }
        }
    }
}