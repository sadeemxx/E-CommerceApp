package com.example.e_commerceapp.ui.address

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.e_commerceapp.R
import com.example.e_commerceapp.data.model.CountryPickerModel
import com.example.e_commerceapp.databinding.ActivityAddNewAddressBinding
import com.example.e_commerceapp.ui.address.adapter.CountryPickerAdapter
import com.example.e_commerceapp.ui.address.adapter.GenaricAdapter
import org.w3c.dom.Text

class AddNewAddressActivity : AppCompatActivity() {
    private val binding by lazy { ActivityAddNewAddressBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding.countryCV.setOnClickListener {
            showCountryPickerRV()
        }

        binding.cityCV.setOnClickListener {
            showCityPickerRV()
        }
        binding.stateCV.setOnClickListener {
            showStatePickerRV()
        }

    }

    private fun showStatePickerRV() {
        binding.statePickerCV.visibility = View.VISIBLE
        binding.stateNameTV.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.arrow_drop_up , 0)

        val bindingInterface = object : GenaricAdapter.GenaricAdapterInterface<String>{
            override fun bindData(item: String, view: View) {
                val cityName : TextView = view.findViewById(R.id.countryNameTV)
                val cityCode : TextView = view.findViewById(R.id.countryCodeTV)
                cityCode.visibility = View.GONE
                cityName.text = item
            }

        }
        binding.statePickerRV.adapter = GenaricAdapter<String>(ProvinceData.provinces , R.layout.item_country_recyclerview , bindingInterface){clickEvent ->
            binding.stateNameTV.text = clickEvent
            binding.statePickerCV.visibility = View.GONE
            binding.stateNameTV.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.arrow_drop_down , 0)
        }
    }

    private fun showCityPickerRV() {
        binding.cityPickerCV.visibility = View.VISIBLE
        binding.cityNameTV.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.arrow_drop_up , 0)

        val bindingInterface = object : GenaricAdapter.GenaricAdapterInterface<String>{
            override fun bindData(item: String, view: View) {
                val cityName : TextView = view.findViewById(R.id.countryNameTV)
                val cityCode : TextView = view.findViewById(R.id.countryCodeTV)
                cityCode.visibility = View.GONE
                cityName.text = item
            }

        }
        binding.cityPickerRV.adapter = GenaricAdapter<String>(CityData.cities , R.layout.item_country_recyclerview , bindingInterface){clickEvent ->
            binding.cityNameTV.text = clickEvent
            binding.cityPickerCV.visibility = View.GONE
            binding.cityNameTV.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.arrow_drop_down , 0)
        }

    }


    private fun showCountryPickerRV() {
        binding.countryPickerCV.visibility = View.VISIBLE
        binding.countryPickerTV.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.arrow_drop_up , 0)


//        binding.countryPickerRV.adapter = CountryPickerAdapter(CountryData.countries ){
//            updateCountryPickerView(it)
//            binding.countryPickerCV.visibility = View.GONE
//            binding.countryPickerTV.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.arrow_drop_down , 0)
//        }
        val bindingInterface = object : GenaricAdapter.GenaricAdapterInterface<CountryPickerModel>{
            override fun bindData(item: CountryPickerModel, view: View) {
                val cName : TextView = view.findViewById(R.id.countryNameTV)
                val cCode : TextView = view.findViewById(R.id.countryCodeTV)
                cName.text = item.countryName
                cCode.text = item.countryCode.toString()
            }

        }
        val adapter = GenaricAdapter<CountryPickerModel>(CountryData.countries , R.layout.item_country_recyclerview , bindingInterface){clickEvent ->
            binding.countryPickerCV.visibility = View.GONE
            binding.countryPickerTV.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.arrow_drop_down , 0)
            updateCountryPickerView("(${clickEvent.countryCode}) ${clickEvent.countryName}")
        }
        binding.countryPickerRV.adapter = adapter
    }

    object CountryData {
        val countries: List<CountryPickerModel> by lazy {
            listOf(
                CountryPickerModel("Pakistan", 92),
                CountryPickerModel("United States", 1),
                CountryPickerModel("India", 91),
                CountryPickerModel("Canada", 1),
                CountryPickerModel("Australia", 61),
                CountryPickerModel("United Kingdom", 44),
                CountryPickerModel("Germany", 49),
                CountryPickerModel("France", 33),
                CountryPickerModel("Japan", 81),
                CountryPickerModel("China", 86)
                // Add more countries as needed
            ).sortedBy { it.countryName }
        }
    }

    object CityData{
        val cities : List<String> by lazy {
            listOf(
                "Karachi",
                "Lahore",
                "Faisalabad",
                "Rawalpindi",
                "Multan",
                "Gujranwala",
                "Hyderabad",
                "Peshawar",
                "Islamabad",
                "Quetta",
                "Sargodha",
                "Sialkot",
                "Bahawalpur",
                "Sukkur",
                "Kandhkot",
                "Sheikhupura",
                "Mardan",
                "Gujrat",
                "Larkana",
                "Kasur",
                "Rahim Yar Khan",
                "Sahiwal",
                "Okara",
                "Dera Ghazi Khan",
                "Mirpur Khas",
                "Sadiqabad",
                "Burewala",
                "Ahmadpur East",
                "Kot Adu",
                "Vehari",
                "Mianwali",
                ).sorted()
        }
    }
    object ProvinceData{
        val provinces : List<String> by lazy {
            listOf(
                "Sindh",
                "Khyber Pakhtunkhwa",
                "Balochistan",
                "Punjab",
            ).sorted()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateCountryPickerView(countryName : String){
        binding.countryPickerTV.text = countryName
    }
}