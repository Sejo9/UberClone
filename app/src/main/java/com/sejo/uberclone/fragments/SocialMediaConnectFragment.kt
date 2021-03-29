package com.sejo.uberclone.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.sejo.uberclone.databinding.FragmentSocialMediaConnectBinding

class SocialMediaConnectFragment : Fragment() {
    private var _binding: FragmentSocialMediaConnectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSocialMediaConnectBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val slideBottom = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)

        val fLast = binding.facebook.translationY
        val gLast = binding.google.translationY

        ObjectAnimator.ofFloat(binding.facebook, "translationY", 1000f, fLast).apply {
            duration = 500
            start()
        }

        ObjectAnimator.ofFloat(binding.google, "translationY", 1000f, gLast).apply {
            duration = 500
            start()
        }

        sharedElementEnterTransition = slideBottom
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}