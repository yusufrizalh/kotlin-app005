package id.yusufrizalh.app005

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_display.*

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        txtDisplayName.text = intent.getStringExtra("name")
        txtDisplayPhone.text = intent.getStringExtra("phone")
        txtDisplayPizzaSize.text = intent.getStringExtra("pizzaSize")
        txtDisplayPickupDate.text = intent.getStringExtra("pickupDate")
        txtDisplayPickupTime.text = intent.getStringExtra("pickupTime")

        btnRate.setOnClickListener {
            txtDisplayRating.text = ratingBar1.rating.toString()
        }

        btnWebView.setOnClickListener {
            var intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }
}