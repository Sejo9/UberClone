package com.sejo.uberclone.fragments

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sejo.uberclone.R
import com.sejo.uberclone.databinding.FragmentPhoneNumberBinding

class PhoneNumberFragment : Fragment() {
    private var _binding: FragmentPhoneNumberBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentPhoneNumberBinding.inflate(layoutInflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).requestWindowFeature(Window.FEATURE_NO_TITLE)

        if (Build.VERSION.SDK_INT >= 23) {
            val window = activity?.window!!
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = resources.getColor(R.color.black,null)
        }



        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}