package uz.devapp.elonuz.main.add_ad.region

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.greenrobot.eventbus.EventBus
import uz.devapp.elonuz.adapters.RegionAdapter
import uz.devapp.elonuz.adapters.RegionAdapterCallback
import uz.devapp.elonuz.data.models.DistrictModel
import uz.devapp.elonuz.data.models.EventModel
import uz.devapp.elonuz.databinding.ActivitySelectRegionBinding
import uz.devapp.elonuz.utils.Constants
import uz.devapp.elonuz.utils.PrefUtils

class SelectRegionActivity : AppCompatActivity(),RegionAdapterCallback {
    lateinit var binding: ActivitySelectRegionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySelectRegionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rv.adapter=RegionAdapter(PrefUtils.getRegions(),this)
    }

    override fun onSelectDistrict(item: DistrictModel) {
        EventBus.getDefault().post(EventModel(Constants.EVENT_SELECT_REGION,item))
        finish()
    }
}