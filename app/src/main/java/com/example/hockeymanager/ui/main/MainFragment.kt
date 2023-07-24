package com.example.hockeymanager.ui.main

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.example.hockeymanager.R
import com.example.hockeymanager.databinding.FragmentMainBinding
import com.example.hockeymanager.ui.club.ClubFragment
import com.example.hockeymanager.ui.group.GroupFragment
import com.example.hockeymanager.ui.home.HomeFragment
import com.example.hockeymanager.ui.store.StoreFragment
import com.example.hockeymanager.ui.transfer.TransferFragment

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
//            val navHostFragment = parentFragmentManager.findFragmentById(R.id.containerView_main) as NavHostFragment
//            val navController = navHostFragment.navController
//            bottomNav.setUpWithNavController
//            navController = findNavController(R.id.containerView_main) as NavController
//            setupActionBarWithNavController(navController)
            bottomNav.setActiveItem(2)
            bottomNav.setOnItemSelectedListener(object :
                    OnItemSelectedListener,
                    me.ibrahimsn.lib.OnItemSelectedListener {
                    override fun onItemSelect(pos: Int) {
                        when (pos) {
                            0 -> setCurrFragment(GroupFragment())
                            1 -> setCurrFragment(ClubFragment())
                            2 -> setCurrFragment(HomeFragment())
                            3 -> setCurrFragment(TransferFragment())
                            4 -> setCurrFragment(StoreFragment())
                        }
                    }

                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {}

                    override fun onNothingSelected(p0: AdapterView<*>?) {}
                })
        }
    }

    private fun setCurrFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.containerView_main, fragment)
            commit()
        }
    }
}
