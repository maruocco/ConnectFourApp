package com.hfad.connectfour

/**
 * Welcome Fragment for when app first opens
 * @author Michael Ruocco
 * @date 2/24/2023
 */

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        val playButton = view.findViewById<Button>(R.id.play)

        playButton.setOnClickListener{
            val playerName = view.findViewById<EditText>(R.id.enterPersonName).text.toString()

            // makes playerName retrievable by next fragment
            val sendName = WelcomeFragmentDirections.actionWelcomeFragmentToGameFragment(playerName)
            view.findNavController().navigate(sendName)
        }
        return view
    }
}