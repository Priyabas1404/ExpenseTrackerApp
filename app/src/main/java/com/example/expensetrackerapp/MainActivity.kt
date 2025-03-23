package com.example.expensetrackerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.expensetrackerapp.ui.ExpenseTrackerApp
import com.example.expensetrackerapp.viewmodel.ExpenseViewModel

class MainActivity : ComponentActivity() {
    private val expenseViewModel: ExpenseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExpenseTrackerApp(expenseViewModel)
        }
    }
}