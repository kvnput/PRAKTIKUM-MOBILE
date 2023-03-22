package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Masukan Tombol di tata letak
        val rollButton: Button = findViewById(R.id.button)

        // Klik pada tombol untuk melempar dadu saat pengguna mengetuk tombol
        rollButton.setOnClickListener { rollDice() }

        // Lakukan lemparan dadu saat aplikasi dimulai
        rollDice()
    }

    private fun rollDice() {
        // Buat objek Dadu baru dengan 6 sisi dan gulung
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Temukan ImageView di tata letak
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Tentukan ID sumber digambar mana yang akan digunakan berdasarkan lemparan dadu
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Perbarui ImageView dengan ID sumber digambar yang benar
        diceImage.setImageResource(drawableResource)

        // Perbarui deskripsi konten
        diceImage.contentDescription = diceRoll.toString()
    }
}

/**
 * Dadu dengan jumlah sisi yang tetap.
 */
class Dice(private val numSides: Int) {

    /**
     * Lakukan lemparan dadu secara acak dan kembalikan hasilnya.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}