package com.example.expensetrackerapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.expensetrackerapp.data.Expense
import com.example.expensetrackerapp.viewmodel.ExpenseViewModel

@Composable
fun ExpenseInput(viewModel: ExpenseViewModel) {
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var amount by remember { mutableStateOf(TextFieldValue("")) }
    var showError by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Expense Title") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = amount,
            onValueChange = {
                amount = it
                showError = it.text.toDoubleOrNull() == null
            },
            label = { Text("Amount") },
            modifier = Modifier.fillMaxWidth(),
            isError = showError
        )

        if (showError) {
            Text(
                text = "Please enter a valid number",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Button(
            onClick = {
                val amountValue = amount.text.toDoubleOrNull()
                if (title.text.isNotEmpty() && amountValue != null) {
                    viewModel.insert(Expense(title = title.text, amount = amountValue))
                    title = TextFieldValue("")
                    amount = TextFieldValue("")
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add Expense")
        }
    }
}