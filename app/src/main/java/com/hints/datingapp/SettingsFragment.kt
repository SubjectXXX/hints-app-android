package com.hints.datingapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.switchmaterial.SwitchMaterial
import com.hints.datingapp.util.ThemeManager
import kotlinx.coroutines.launch

class SettingsFragment : Fragment() {
    
    private lateinit var themeSwitch: SwitchMaterial
    private lateinit var themeManager: ThemeManager
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        themeSwitch = view.findViewById(R.id.theme_switch)
        themeManager = ThemeManager(requireContext())
        
        // Load current theme setting
        lifecycleScope.launch {
            themeManager.isNightMode.collect { isNightMode ->
                themeSwitch.isChecked = isNightMode
            }
        }
        
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            lifecycleScope.launch {
                themeManager.setNightMode(isChecked)
                AppCompatDelegate.setDefaultNightMode(
                    if (isChecked) AppCompatDelegate.MODE_NIGHT_YES
                    else AppCompatDelegate.MODE_NIGHT_NO
                )
            }
        }
    }
}
