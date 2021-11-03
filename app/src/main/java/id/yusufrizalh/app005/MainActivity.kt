package id.yusufrizalh.app005

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var slider: SeekBar
        lateinit var value: TextView

        slider = seekPizzaSize
        value = txtPizzaSize

        val pizzaSize = arrayListOf<String>("Select One", "Small", "Medium", "Large", "Xtra Large")

        slider.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                value.text = pizzaSize[progress]
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

        btnSelectDate.setOnClickListener {
            val cal = Calendar.getInstance()
            val day = cal.get(Calendar.DAY_OF_MONTH)
            val month = cal.get(Calendar.MONTH)
            val year = cal.get(Calendar.YEAR)

            val myDatePicker = DatePickerDialog(this, android.R.style.ThemeOverlay, DatePickerDialog.OnDateSetListener { DatePicker, Year, Month, Day ->
                txtSelectDate.text = "$Day / ${Month + 1} / $Year" }, year, month, day)
            myDatePicker.show()
        }

        btnSelectTime.setOnClickListener {
            val cal = Calendar.getInstance()
            val hour = cal.get(Calendar.HOUR_OF_DAY)
            val minutes = cal.get(Calendar.MINUTE)

            val myTimePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { TimePicker, hourOfDay, minute ->
                txtSelectTime.text = "$hourOfDay : $minute" }, hour, minutes, true)
            myTimePicker.show()
        }

        btnSchedule.setOnClickListener {
            var intent = Intent(this, DisplayActivity::class.java)
            intent.putExtra("name", editName.text.toString())
            intent.putExtra("phone", editPhone.text.toString())
            intent.putExtra("pizzaSize", txtPizzaSize.text.toString())
            intent.putExtra("pickupDate", txtSelectDate.text.toString())
            intent.putExtra("pickupTime", txtSelectTime.text.toString())
            startActivity(intent)
        }
    }
}