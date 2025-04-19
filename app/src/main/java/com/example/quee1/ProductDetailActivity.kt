package com.example.quee1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var product: Product
    private var quantity = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        val productTitle: TextView = findViewById(R.id.productTitle)
        val productPrice: TextView = findViewById(R.id.productPrice)
        val quantityText: TextView = findViewById(R.id.quantityText)

        product = intent.getSerializableExtra("product") as Product

        productTitle.text = product.name
        productPrice.text = "$${product.price}"
        quantityText.text = quantity.toString()

        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            quantity++
            quantityText.text = quantity.toString()
        }

        findViewById<Button>(R.id.btnMinus).setOnClickListener {
            if (quantity > 1) {
                quantity--
                quantityText.text = quantity.toString()
            }
        }

        findViewById<Button>(R.id.btnAddToCart).setOnClickListener {
            // Add to cart logic here
        }
    }
}
