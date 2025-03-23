package com.example.expensetrackerapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.livedata.observeAsState
import com.example.expensetrackerapp.viewmodel.ExpenseViewModel

@Composable
fun ExpenseList(viewModel: ExpenseViewModel) {
    val expenses by viewModel.allExpenses.observeAsState(emptyList())

    LazyColumn {
        items(expenses) { expense ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .shadow(4.dp)
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(text = expense.title, style = MaterialTheme.typography.titleLarge)
                        Text(text = "\$${String.format("%.2f", expense.amount)}")
                    }
                    Button(onClick = { viewModel.delete(expense) }) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}