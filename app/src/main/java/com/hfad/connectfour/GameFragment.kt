package com.hfad.connectfour

/**
 * Game Fragment allows user to communicate with the FourInARow class
 * @author Michael Ruocco
 * @date 2/24/2023
 */

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class GameFragment : Fragment(), View.OnClickListener {

    private val FIR_board = FourInARow()
    var winStatus = 0
    var cpTurn = false

    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        if (bundle == null) {
            Log.e("GameFragment", "GameFragment did not recieve a player name")
            return
        }

        // retrieves playerName
        name = GameFragmentArgs.fromBundle(bundle).name.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // reset board on game start
        reset()

        // set name
        requireActivity().findViewById<TextView>(R.id.player_name).text = name

        // add button listeners
        view.findViewById<ImageButton>(R.id.button_0_0).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_0_1).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_0_2).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_0_3).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_0_4).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_0_5).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_1_0).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_1_1).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_1_2).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_1_3).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_1_4).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_1_5).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_2_0).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_2_1).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_2_2).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_2_3).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_2_4).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_2_5).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_3_0).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_3_1).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_3_2).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_3_3).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_3_4).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_3_5).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_4_0).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_4_1).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_4_2).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_4_3).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_4_4).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_4_5).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_5_0).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_5_1).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_5_2).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_5_3).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_5_4).setOnClickListener(this)
        view.findViewById<ImageButton>(R.id.button_5_5).setOnClickListener(this)
        view.findViewById<Button>(R.id.restart).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var x = -1

        // sets column depending on button clicked
        when (v!!.id) {

            // resets display and clears the connect four array
            R.id.restart -> {
                if (winStatus != 0) {
                    FIR_board.clearBoard()
                    reset()
                    winStatus = 0
                }
            }

            R.id.button_0_0 -> {
                x = 0

            }
            R.id.button_0_1 -> {
                x = 0

            }
            R.id.button_0_2 -> {
                x = 0

            }
            R.id.button_0_3 -> {
                x = 0

            }
            R.id.button_0_4 -> {
                x = 0

            }
            R.id.button_0_5 -> {
                x = 0

            }
            R.id.button_1_0 -> {
                x = 1

            }
            R.id.button_1_1 -> {
                x = 1

            }
            R.id.button_1_2 -> {
                x = 1

            }
            R.id.button_1_3 -> {
                x = 1

            }
            R.id.button_1_4 -> {
                x = 1

            }
            R.id.button_1_5 -> {
                x = 1

            }
            R.id.button_2_0 -> {
                x = 2

            }
            R.id.button_2_1 -> {
                x = 2

            }
            R.id.button_2_2 -> {
                x = 2

            }
            R.id.button_2_3 -> {
                x = 2

            }
            R.id.button_2_4 -> {
                x = 2

            }
            R.id.button_2_5 -> {
                x = 2

            }
            R.id.button_3_0 -> {
                x = 3

            }
            R.id.button_3_1 -> {
                x = 3

            }
            R.id.button_3_2 -> {
                x = 3

            }
            R.id.button_3_3 -> {
                x = 3

            }
            R.id.button_3_4 -> {
                x = 3

            }
            R.id.button_3_5 -> {
                x = 3

            }
            R.id.button_4_0 -> {
                x = 4

            }
            R.id.button_4_1 -> {
                x = 4

            }
            R.id.button_4_2 -> {
                x = 4

            }
            R.id.button_4_3 -> {
                x = 4

            }
            R.id.button_4_4 -> {
                x = 4

            }
            R.id.button_4_5 -> {
                x = 4

            }
            R.id.button_5_0 -> {
                x = 5

            }
            R.id.button_5_1 -> {
                x = 5

            }
            R.id.button_5_2 -> {
                x = 5

            }
            R.id.button_5_3 -> {
                x = 5

            }
            R.id.button_5_4 -> {
                x = 5

            }
            R.id.button_5_5 -> {
                x = 5

            }
        }

        // if a buttton is pressed, game isn't over, isn't cps turn
        if (x != -1 && winStatus == 0 && !cpTurn) {
            // set player move in array
            if (setArray(1, x)) {
                // if that move didn't win then the cp goes
                if (FIR_board.checkForWinner() != 1) {
                    setArray(2, FIR_board.computerMove)
                }
                // check for a winner
                winStatus = FIR_board.checkForWinner()
                winCheck()
            }
        }
    }

    // checks for winner and sets labels accordingly
    private fun winCheck() {
        if (winStatus != 0) {
            when (winStatus) {
                1 -> {
                    requireActivity().findViewById<TextView>(R.id.status).text =
                        resources.getString(R.string.player_win)
                }
                2 -> {
                    requireActivity().findViewById<TextView>(R.id.status).text =
                        resources.getString(R.string.cp_win)
                }
                3 -> {
                    requireActivity().findViewById<TextView>(R.id.status).text =
                        resources.getString(R.string.tie)
                }
            }

            // shows restart button is now active
            requireActivity().findViewById<Button>(R.id.restart).setBackgroundColor(Color.GREEN)
        }
    }

    // restores the game to default
    private fun reset() {
        FIR_board.clearBoard()
        requireActivity().findViewById<TextView>(R.id.status).text =
            resources.getString(R.string.player_turn)
        requireActivity().findViewById<Button>(R.id.restart).setBackgroundColor(Color.BLACK)
        requireActivity().findViewById<ImageButton>(R.id.button_0_0)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_0_1)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_0_2)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_0_3)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_0_4)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_0_5)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_1_0)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_1_1)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_1_2)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_1_3)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_1_4)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_1_5)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_2_0)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_2_1)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_2_2)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_2_3)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_2_4)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_2_5)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_3_0)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_3_1)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_3_2)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_3_3)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_3_4)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_3_5)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_4_0)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_4_1)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_4_2)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_4_3)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_4_4)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_4_5)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_5_0)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_5_1)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_5_2)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_5_3)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_5_4)
            .setImageResource(R.drawable.gray)
        requireActivity().findViewById<ImageButton>(R.id.button_5_5)
            .setImageResource(R.drawable.gray)
    }

    // decides where in the connet four array to place the piece based on the button pressed
    private fun setArray(player: Int, x: Int) : Boolean {
        var selected = R.id.button_0_0
        if (FIR_board.setMove(player, x)) {
            val x = FIR_board.getX()
            val y = FIR_board.getY()
            if (y in 0..5) {
                if (x == 0) {
                    if (y == 0) {
                        selected = R.id.button_0_0
                    }
                    if (y == 1) {
                        selected = R.id.button_0_1
                    }
                    if (y == 2) {
                        selected = R.id.button_0_2
                    }
                    if (y == 3) {
                        selected = R.id.button_0_3
                    }
                    if (y == 4) {
                        selected = R.id.button_0_4
                    }
                    if (y == 5) {
                        selected = R.id.button_0_5
                    }
                }
                if (x == 1) {
                    if (y == 0) {
                        selected = R.id.button_1_0
                    }
                    if (y == 1) {
                        selected = R.id.button_1_1
                    }
                    if (y == 2) {
                        selected = R.id.button_1_2
                    }
                    if (y == 3) {
                        selected = R.id.button_1_3
                    }
                    if (y == 4) {
                        selected = R.id.button_1_4
                    }
                    if (y == 5) {
                        selected = R.id.button_1_5
                    }
                }
                if (x == 2) {
                    if (y == 0) {
                        selected = R.id.button_2_0
                    }
                    if (y == 1) {
                        selected = R.id.button_2_1
                    }
                    if (y == 2) {
                        selected = R.id.button_2_2
                    }
                    if (y == 3) {
                        selected = R.id.button_2_3
                    }
                    if (y == 4) {
                        selected = R.id.button_2_4
                    }
                    if (y == 5) {
                        selected = R.id.button_2_5
                    }
                }
                if (x == 3) {
                    if (y == 0) {
                        selected = R.id.button_3_0
                    }
                    if (y == 1) {
                        selected = R.id.button_3_1
                    }
                    if (y == 2) {
                        selected = R.id.button_3_2
                    }
                    if (y == 3) {
                        selected = R.id.button_3_3
                    }
                    if (y == 4) {
                        selected = R.id.button_3_4
                    }
                    if (y == 5) {
                        selected = R.id.button_3_5
                    }
                }
                if (x == 4) {
                    if (y == 0) {
                        selected = R.id.button_4_0
                    }
                    if (y == 1) {
                        selected = R.id.button_4_1
                    }
                    if (y == 2) {
                        selected = R.id.button_4_2
                    }
                    if (y == 3) {
                        selected = R.id.button_4_3
                    }
                    if (y == 4) {
                        selected = R.id.button_4_4
                    }
                    if (y == 5) {
                        selected = R.id.button_4_5
                    }
                }
                if (x == 5) {
                    if (y == 0) {
                        selected = R.id.button_5_0
                    }
                    if (y == 1) {
                        selected = R.id.button_5_1
                    }
                    if (y == 2) {
                        selected = R.id.button_5_2
                    }
                    if (y == 3) {
                        selected = R.id.button_5_3
                    }
                    if (y == 4) {
                        selected = R.id.button_5_4
                    }
                    if (y == 5) {
                        selected = R.id.button_5_5
                    }
                }

                // use of a timer to have the CP 'take time to decide' their move, also sets their move
                val timer = object : CountDownTimer(1000, 200) {
                    override fun onTick(millisUntilFinished: Long) {
                        requireActivity().findViewById<TextView>(R.id.status).text =
                            resources.getString(R.string.cp_turn)
                        cpTurn = true
                    }

                    override fun onFinish() {
                        requireActivity().findViewById<ImageButton>(selected)
                            .setImageResource(R.drawable.red)
                        if (winStatus == 0) {
                            requireActivity().findViewById<TextView>(R.id.status).text =
                                resources.getString(R.string.player_turn)
                        }
                        cpTurn = false
                        winCheck()
                    }
                }

                if (player == 1) {
                    requireActivity().findViewById<ImageButton>(selected)
                        .setImageResource(R.drawable.blue)
                } else {
                    timer.start()
                }
                FIR_board.isTrue()
            }
            return true
        }
        return false
    }

}