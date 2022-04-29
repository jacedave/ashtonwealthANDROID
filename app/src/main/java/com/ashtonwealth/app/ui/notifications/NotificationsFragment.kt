package com.ashtonwealth.app.ui.notifications

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.ashtonwealth.app.R
import com.ashtonwealth.app.databinding.FragmentContactBinding
import com.ashtonwealth.app.databinding.FragmentEventsBinding
import com.ashtonwealth.app.databinding.FragmentHomeBinding
import com.ashtonwealth.app.ui.home.HomeViewModel

class NotificationsFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null
    private lateinit var callButton: ImageButton
    private lateinit var textButton: ImageButton
    private lateinit var emailButton: ImageButton
    private lateinit var scheduleButton: ImageButton
    private lateinit var textAFriendButton: ImageButton
    private lateinit var referralButton: ImageButton

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(NotificationsViewModel::class.java)

        _binding = FragmentContactBinding.inflate(inflater, container, false)
        val root: View = binding.root
        callButton = binding.callOfficeContacts
        textButton = binding.textOffice
        emailButton = binding.emailOffice
        scheduleButton = binding.scheduleAppt
        textAFriendButton = binding.textAFriend
        referralButton = binding.referralPassalong
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
        textButton.setOnClickListener {
            val uri = "435-688-9500".trim()
            val message = "Send us a message please!"
            composeSmsMessage(message, uri)
        }
        emailButton.setOnClickListener {
            val addresses = arrayOf<String>("mandy@ashtonwealth.com","abeashton@ashtonwealth.com")
            val subject = "Client Email"
            composeEmail(addresses, subject)
        }
        scheduleButton.setOnClickListener {
            CustomTabsIntent.Builder().setToolbarColor(ContextCompat.getColor(requireContext(), R.color.Ashton_Blue))
                .setShowTitle(true).build().launchUrl(requireContext(), Uri.parse("https://forms.gle/2zeNau7YrZfRbFJh6"))
        }
        textAFriendButton.setOnClickListener {
            val message = "Recently, I was talking to my financial guy, his name is Abe Ashton, and I thought that he might be able to " +
                    "help you like he has helped me. I have been working with him for a while, his company is call Ashton and Associates, " +
                    "and if you want to learn more about them, their number is 435-688-9500, and their website is www.ashtonwealth.com, I hope that" +
                    " you will see the same wonderful things that I see in Abe and his team!"
            composeSmsMessageNoNum(message)
        }
        referralButton.setOnClickListener {
            CustomTabsIntent.Builder().setToolbarColor(ContextCompat.getColor(requireContext(), R.color.Ashton_Blue))
                .setShowTitle(true).build().launchUrl(requireContext(), Uri.parse("https://forms.gle/EGBuXDRxVkAk67Pq8"))
        }
    }

    fun composeSmsMessage(message: String, number: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            data = Uri.parse("smsto:$number")  // This ensures only SMS apps respond
            putExtra("sms_body", message)
        }
        startActivity(intent)
    }

    fun composeSmsMessageNoNum(message: String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            data = Uri.parse("smsto:")  // This ensures only SMS apps respond
            putExtra("sms_body", message)
        }
        startActivity(intent)
    }

    fun composeEmail(addresses: Array<String>, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        startActivity(intent)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}