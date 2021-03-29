package com.sejo.uberclone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.sejo.uberclone.databinding.CountryHeaderBinding
import com.sejo.uberclone.databinding.CountryItemBinding
import com.sejo.uberclone.fragments.CountriesFragmentDirections
import com.sejo.uberclone.models.Country

class CountriesRecyclerAdapter(private val countries: List<Country>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class HeaderViewHolder(binding: CountryHeaderBinding) : RecyclerView.ViewHolder(binding.root) {

        private val groupLetter = binding.groupLetter

        fun bind(letter: String) {
            groupLetter.text = letter
        }
    }

    inner class CountryViewHolder(binding: CountryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val flag = binding.flag
        private val codeName = binding.codeName

        fun bind(item: Country) {
            flag.setImageResource(item.image)
            codeName.text = item.name.plus(" (${item.code})")

            itemView.setOnClickListener {
                val action = CountriesFragmentDirections.actionCountriesFragmentToPhoneNumberFragment(item.image, item.code)
                Navigation.findNavController(it).navigate(action)
            }
        }

    }


    override fun getItemViewType(position: Int): Int {

        return if (countries[position].code.isEmpty()) {
            0
        } else {
            1
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val binding = CountryHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            HeaderViewHolder(binding)
        } else {
            val binding = CountryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            CountryViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = countries[position]

        return if (item.image == 0) {
            (holder as HeaderViewHolder).bind(item.name)
        } else {
            (holder as CountryViewHolder).bind(item)
        }
    }

    override fun getItemCount(): Int {
        return countries.size
    }
}