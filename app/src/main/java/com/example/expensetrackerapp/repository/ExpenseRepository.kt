package com.example.expensetrackerapp.repository

import androidx.lifecycle.LiveData
import com.example.expensetrackerapp.data.Expense
import com.example.expensetrackerapp.data.ExpenseDao

class ExpenseRepository(private val expenseDao: ExpenseDao) {
    val allExpenses: LiveData<List<Expense>> = expenseDao.getAllExpenses()

    suspend fun insert(expense: Expense) {
        expenseDao.insert(expense)
    }

    suspend fun delete(expense: Expense) {
        expenseDao.delete(expense)
    }
}