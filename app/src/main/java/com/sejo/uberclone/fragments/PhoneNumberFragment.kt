package com.sejo.uberclone.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sejo.uberclone.EditTextKeyboardLifecycleObserver
import com.sejo.uberclone.R
import com.sejo.uberclone.databinding.FragmentPhoneNumberBinding
import java.lang.ref.WeakReference

class PhoneNumberFragment : Fragment() {
    private var _binding: FragmentPhoneNumberBinding? = null
    private val binding get() = _binding!!

    private val args: PhoneNumberFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentPhoneNumberBinding.inflate(layoutInflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.show()

        val window = activity?.window!!
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = ResourcesCompat.getColor(resources, R.color.black, null)

        if (args.flag != 0) {
            binding.countryCode.text = args.code
            binding.phoneFlag.setImageResource(args.flag)
        }

        binding.countryPickerBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_phoneNumberFragment_to_countriesFragment))

        binding.socialConnect.setOnClickListener {
            val extras = FragmentNavigatorExtras(binding.phoneHeader to "sheader")
            findNavController().navigate(
                    R.id.action_phoneNumberFragment_to_socialMediaConnectFragment,
                    null,
                    null,
                    extras
            )
        }

        binding.phoneNextBtn.setOnClickListener {
            if (binding.numberLayout.editText?.text?.isEmpty()!!) {
                binding.numberLayout.isErrorEnabled = true
                binding.numberLayout.error = "Please enter your mobile number"
            }
        }

        binding.numberLayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.numberLayout.isErrorEnabled) binding.numberLayout.isErrorEnabled = false
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(EditTextKeyboardLifecycleObserver(WeakReference(binding.numberLayout.editText)))
    }

    override fun onPause() {
        super.onPause()
        binding.numberLayout.isErrorEnabled = false
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}