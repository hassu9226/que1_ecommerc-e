package com.example.quee1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productList: List<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        productList = listOf(
            Product(1, "T-shirt", 19.99, "Clothing", listOf("image1.jpg", "image2.jpg")),
            Product(2, "Laptop", 499.99, "Electronics", listOf("image1.jpg", "image2.jpg")),
            Product(3, "Sofa", 299.99, "Home", listOf("image1.jpg", "image2.jpg")),
            Product(4, "Jeans", 39.99, "Clothing", listOf("image1.jpg"))
        )

        productAdapter = ProductAdapter(productList) { product ->
            val intent = Intent(this, ProductDetailActivity::class.java)
            intent.putExtra("product", product)
            startActivity(intent)
        }

        recyclerView.adapter = productAdapter

        findViewById<Button>(R.id.btnAll).setOnClickListener { filterProducts("") }
        findViewById<Button>(R.id.btnClothing).setOnClickListener { filterProducts("Clothing") }
        findViewById<Button>(R.id.btnElectronics).setOnClickListener { filterProducts("Electronics") }
        findViewById<Button>(R.id.btnHome).setOnClickListener { filterProducts("Home") }
    }

    private fun filterProducts(category: String) {
        val filtered = if (category.isEmpty()) productList else productList.filter { it.category == category }
        productAdapter.updateList(filtered)
    }
}
