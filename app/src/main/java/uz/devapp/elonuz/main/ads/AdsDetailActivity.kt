package uz.devapp.elonuz.main.ads

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.devapp.elonuz.data.models.AdsModel
import uz.devapp.elonuz.data.models.CategoryModel
import uz.devapp.elonuz.databinding.ActivityAdsDetailBinding
import uz.devapp.elonuz.utils.Constants

class AdsDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdsDetailBinding
    lateinit var adsModel: AdsModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAdsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root )
        if (Build.VERSION.SDK_INT < 33) {
            adsModel = intent.getSerializableExtra(Constants.EXTRA_DATA) as AdsModel
        } else {
            adsModel =
                intent.getSerializableExtra(Constants.EXTRA_DATA, AdsModel::class.java)!!
        }
    }
}