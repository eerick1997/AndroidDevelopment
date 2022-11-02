package com.lyft.android.mealtime

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.emoji2.bundled.BundledEmojiCompatConfig
import androidx.emoji2.text.EmojiCompat

class MainActivity : AppCompatActivity() {

    private var isSelectedCheeseButton = false
    private var isSelectedSteakButton = false
    private var isSelectedBreadButton = false
    private var selectedMeals = mutableListOf<Food>()
    private var currentMeal = 0
    private lateinit var buttonSteak: Button
    private lateinit var buttonCheese: Button
    private lateinit var buttonBread: Button
    private lateinit var currentMealTV: TextView

    private var intScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EmojiCompat.init(BundledEmojiCompatConfig(this))
        setContentView(R.layout.activity_main)

        setupUi()
    }

    // Renders the initial UI. This is only meant to be called once.
    private fun setupUi() {
        var nextMeal = TheKitchen.CHEF_SAMPLES[currentMeal]

        currentMealTV = findViewById<TextView>(R.id.next_meal_textview)
            .apply {
                text = nextMeal.joinToString(separator = "") { it.emojiString }
            }

        val tvScore = findViewById<TextView>(R.id.score_count_textview)
            .apply {
                text = resources.getString(R.string.score_count, 0)
            }

        buttonCheese = findViewById<Button>(R.id.food_button_1)
            .apply {
                text = Food.CHEESE.emojiString
                setBackgroundColor(UNSELECTED_COLOR)
                setOnClickListener {
                    if (!isSelectedCheeseButton) {
                        setBackgroundColor(SELECTED_COLOR)
                        selectedMeals.add(Food.CHEESE)
                    } else {
                        setBackgroundColor(UNSELECTED_COLOR)
                        selectedMeals.remove(Food.CHEESE)
                    }
                    isSelectedCheeseButton = !isSelectedCheeseButton
                }
            }

        buttonSteak = findViewById<Button>(R.id.food_button_2)
            .apply {
                text = Food.STEAK.emojiString
                setBackgroundColor(UNSELECTED_COLOR)
                setOnClickListener {
                    if (!isSelectedSteakButton) {
                        setBackgroundColor(SELECTED_COLOR)
                        selectedMeals.add(Food.STEAK)
                    } else {
                        setBackgroundColor(UNSELECTED_COLOR)
                        selectedMeals.remove(Food.STEAK)
                    }
                    isSelectedSteakButton = !isSelectedSteakButton
                }
            }

        buttonBread = findViewById<Button>(R.id.food_button_3)
            .apply {
                text = Food.BREAD.emojiString
                setBackgroundColor(UNSELECTED_COLOR)
                setOnClickListener {
                    if (!isSelectedBreadButton) {
                        setBackgroundColor(SELECTED_COLOR)
                        selectedMeals.add(Food.BREAD)
                    } else {
                        setBackgroundColor(UNSELECTED_COLOR)
                        selectedMeals.remove(Food.BREAD)
                    }
                    isSelectedBreadButton = !isSelectedBreadButton
                }
            }

        findViewById<Button>(R.id.deliver_button)
            .apply {
                setOnClickListener {
                    if (selectedMeals.size == nextMeal.size && selectedMeals.containsAll(nextMeal)) {
                        if (++currentMeal >= TheKitchen.CHEF_SAMPLES.size) {
                            tvScore.text = "Completed"
                            return@setOnClickListener
                        } else {
                            nextMeal = TheKitchen.CHEF_SAMPLES[currentMeal]
                            resetButtonStates(nextMeal)
                            selectedMeals.clear()
                            intScore += 10
                        }
                    } else if (intScore >= 5){
                        intScore -= 5
                    }
                    tvScore.text = "Score: $intScore"
                }
        }
    }

    private fun resetButtonStates(nextMeal: List<Food>) {
        isSelectedBreadButton = false
        isSelectedCheeseButton = false
        isSelectedSteakButton = false
        buttonCheese.setBackgroundColor(UNSELECTED_COLOR)
        buttonSteak.setBackgroundColor(UNSELECTED_COLOR)
        buttonBread.setBackgroundColor(UNSELECTED_COLOR)
        currentMealTV.apply {
            text = nextMeal.joinToString(separator = "") { it.emojiString }
        }
    }

    companion object {
        private const val UNSELECTED_COLOR = Color.LTGRAY
        private const val SELECTED_COLOR = Color.YELLOW
    }
}
