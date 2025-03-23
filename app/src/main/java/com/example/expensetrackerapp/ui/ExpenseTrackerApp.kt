package com.example.expensetrackerapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.expensetrackerapp.viewmodel.ExpenseViewModel

@Composable
fun ExpenseTrackerApp(viewModel: ExpenseViewModel) {
    Column(modifier = Modifier.padding(16.dp)) {
        ExpenseInput(viewModel)
        ExpenseList(viewModel)
    }
}