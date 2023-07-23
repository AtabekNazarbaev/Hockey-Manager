package com.example.hockeymanager.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.hockeymanager.R
import com.example.hockeymanager.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val navHostFragment = parentFragmentManager.findFragmentById(R.id.containerView_main) as NavHostFragment
            val navController = navHostFragment.navController
            bottomNav.setUpWithNavController
            bottomNav.setActiveItem(2)
            bottomNav.setOnItemSelectedListener(object :
                    OnItemSelectedListener,
                    me.ibrahimsn.lib.OnItemSelectedListener {
                    override fun onItemSelect(pos: Int) {
                        Toast.makeText(requireContext(), "fragment$pos", Toast.LENGTH_SHORT).show()
                    }

                  override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {}

                    override fun onNothingSelected(p0: AdapterView<*>?) {}
                })
        }
    }
}
