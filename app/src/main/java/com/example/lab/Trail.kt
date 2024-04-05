package com.example.lab

data class Trail(
    val name: String,
    val stages: List<String>,
    val description: String,
    val estimatedTimes: List<Int>
)
