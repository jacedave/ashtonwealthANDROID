package com.ashtonwealth.app.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ashtonwealth.app.R
import com.ashtonwealth.app.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var callButton: ImageButton
    private lateinit var navButton: ImageButton
    private lateinit var facebookButton: ImageButton
    private lateinit var instaButton: ImageButton
    private lateinit var twittaButton: ImageButton
    private lateinit var blueleafButton: Button

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
                ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val imageView: TextView = binding.textView
        homeViewModel.text.observe(viewLifecycleOwner) {
            imageView.text = it
        }
        callButton = binding.imageView2
        navButton = binding.imageView3
        facebookButton = binding.facebook!!
        instaButton = binding.insta!!
        twittaButton = binding.twitta!!
        blueleafButton = binding.blueleaf!!

        return root
    }

    override fun onStart() {
        super.onStart()
        callButton.setOnClickListener {
            val uri = "tel: 435-688-9500".trim()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(uri)
            startActivity(intent)
        }
        navButton.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:37.066534532951366, -113.54917723080895?q=" + Uri.encode("Ashton and Associates, St. George"))
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        facebookButton.setOnClickListener {
            CustomTabsIntent.Builder().setToolbarColor(ContextCompat.getColor(requireContext(), R.color.Ashton_Blue))
                .setShowTitle(true).build().launchUrl(requireContext(), Uri.parse("https://www.facebook.com/ashtonwealth"))
        }
        instaButton.setOnClickListener {
            CustomTabsIntent.Builder().setToolbarColor(ContextCompat.getColor(requireContext(), R.color.Ashton_Blue))
                .setShowTitle(true).build().launchUrl(requireContext(), Uri.parse("https://www.instagram.com/ashtonwealth/"))
        }
        twittaButton.setOnClickListener {
            CustomTabsIntent.Builder().setToolbarColor(ContextCompat.getColor(requireContext(), R.color.Ashton_Blue))
                .setShowTitle(true).build().launchUrl(requireContext(), Uri.parse("https://twitter.com/AshtonWealth"))
        }
        blueleafButton.setOnClickListener {
            CustomTabsIntent.Builder().setToolbarColor(ContextCompat.getColor(requireContext(), R.color.Ashton_Blue))
                .setShowTitle(true).build().launchUrl(requireContext(), Uri.parse("https://authentication.blueleaf.com/"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}