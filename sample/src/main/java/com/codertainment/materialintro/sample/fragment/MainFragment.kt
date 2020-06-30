package com.codertainment.materialintro.sample.fragment

import android.graphics.drawable.LayerDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.codertainment.materialintro.sample.R
import com.codertainment.materialintro.shape.Focus
import com.codertainment.materialintro.shape.ShapeType
import com.codertainment.materialintro.utils.materialIntro
import com.codertainment.materialintro.utils.resetAllMivs
import com.codertainment.materialintro.view.MaterialIntroView
import kotlinx.android.synthetic.main.content_main.*

class MainFragment : Fragment() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.content_main, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    button_reset_all.setOnClickListener {
      if (activity == null) return@setOnClickListener
      requireContext().resetAllMivs()
    }
    showIntro(my_card, INTRO_CARD, "This is the info card! Hello There. You can set this text!")
  }


  private fun showIntro(view: View, usageId: String, text: String) {

    materialIntro(true) {
      focusType = Focus.MINIMUM
      isPerformClick = true
      infoText = text
      showOnlyOnce = false
      isHelpIconEnabled = false
      targetView = view
      shapeType = ShapeType.RECTANGLE
      viewId = usageId
      infoCardViewRes = R.drawable.custom_border
      dismissOnTarget = true
    }

  }

  companion object {
    private const val INTRO_CARD = "material_intro"
  }
}