package com.sejo.uberclone.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.sejo.uberclone.R
import com.sejo.uberclone.adapters.CountriesRecyclerAdapter
import com.sejo.uberclone.databinding.FragmentCountriesBinding
import com.sejo.uberclone.models.Country

class CountriesFragment : Fragment() {
    private var _binding: FragmentCountriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        _binding = FragmentCountriesBinding.inflate(layoutInflater, container, false)

        (activity as AppCompatActivity).supportActionBar?.hide()

        binding.countriesToolbar.setupWithNavController(findNavController())

        val countries = listOf<Country>(
                Country(0, "CURRENT LOCATION", ""),
                Country(R.drawable.ic_united_kingdom_flag, "United Kingdom", "+44"),
                Country(0, "A", ""),
                Country(R.drawable.ic_afghanistan_flag, "Afghanistan", "+93"),
                Country(R.drawable.ic_angola_flag, "Angola", "+244"),
                Country(0, "B", ""),
                Country(R.drawable.ic_belgium_flag, "Belgium", "+32"),
                Country(R.drawable.ic_benin_flag, "Benin", "+229"),
                Country(0, "C", ""),
                Country(R.drawable.ic_canada_flag, "Canada", "+1"),
                Country(R.drawable.ic_cameroon_flag, "Cameroon", "+237"),
                Country(0, "D", ""),
                Country(R.drawable.ic_denmark_flag, "Denmark", "+45"),
                Country(R.drawable.ic_djibouti_flag, "Djibouti", "+253"),
                Country(0, "E", ""),
                Country(R.drawable.ic_egypt_flag, "Egypt", "+20"),
                Country(R.drawable.ic_ethiopia_flag, "Ethiopia", "+251"),
                Country(0, "F", ""),
                Country(R.drawable.ic_fiji_flag, "Fiji", "+679"),
                Country(R.drawable.ic_france_flag, "France", "+33"),
                Country(0, "G", ""),
                Country(R.drawable.ic_germany_flag, "Germany", "+49"),
                Country(R.drawable.ic_ghana_24, "Ghana", "+233"),
                Country(0, "H", ""),
                Country(R.drawable.ic_haiti_flag, "Haiti", "+509"),
                Country(R.drawable.ic_hungary_flag, "Hungary", "+36"),
        )

        binding.countriesRecycler.adapter = CountriesRecyclerAdapter(countries)

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}