package com.codertainment.materialintro.sample.fragment.sequence

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.codertainment.materialintro.sample.R
import com.codertainment.materialintro.sequence.MaterialIntroSequence
import com.codertainment.materialintro.shape.ShapeType
import com.codertainment.materialintro.utils.materialIntroSequence
import kotlinx.android.synthetic.main.fragment_child1.*
import org.jetbrains.anko.support.v4.toast

class Child1Fragment : Fragment() {

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_child1, container, false)
  }

  override fun onResume() {
    super.onResume()
    Log.d("child1", "onResume")
    val introSequence = MaterialIntroSequence(activity!!).apply {
      showSkip = false
      persistSkip = false
      initialDelay = 500
    }
    introSequence.addConfig {
      shapeType = ShapeType.RECTANGLE
      viewId = "c1_b3"
      showOnlyOnce = true
      dismissOnTarget =false
      targetView = child1_button1
      infoCardViewRes = R.drawable.custom_border
      infoText = "This is intro for Child1's Button1"
    }
    introSequence.addConfig {
      shapeType = ShapeType.RECTANGLE
      viewId = "c1_b4"
      showOnlyOnce = true
      dismissOnTarget = false
      targetView = child1_button2
      infoCardViewRes = R.drawable.custom_border
      infoText = "This is intro for Child1's Button2"
    }
    val button1 = addCmButton()
    val button2 = addCmButton()
    button2.setOnClickListener {
      introSequence.mivs[introSequence.counter-1].dismiss()
    }
    button1.setOnClickListener {
      introSequence.nextIntro()
      introSequence.mivs[introSequence.counter-1].dismiss()
      introSequence.mivs[introSequence.counter].addView(button2)
    }
    introSequence.mivs[introSequence.counter].addView(button1)
    introSequence.start()
  }

  private fun addCmButton() : Button {
    val button = Button(requireContext())
    val params = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
    )
    params.setMargins(250, 150,0,450)
    button.layoutParams = params
    button.setBackgroundResource(R.drawable.custom_border)
    button.text = "Got It!"
    button.isAllCaps = false
    button.setTextColor(ContextCompat.getColor(requireContext(),R.color.colorPrimary))
    return button
  }
}
