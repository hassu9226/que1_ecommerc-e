package com.example.quee1

import java.io.Serializable

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val category: String,
    val images: List<String>
) : Serializable
