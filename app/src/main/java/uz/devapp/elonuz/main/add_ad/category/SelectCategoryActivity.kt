package uz.devapp.elonuz.main.add_ad.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.greenrobot.eventbus.EventBus
import uz.devapp.elonuz.adapters.CategoryAdapter
import uz.devapp.elonuz.adapters.CategoryAdapterCallback
import uz.devapp.elonuz.adapters.RegionAdapter
import uz.devapp.elonuz.data.models.CategoryModel
import uz.devapp.elonuz.data.models.DistrictModel
import uz.devapp.elonuz.data.models.EventModel
import uz.devapp.elonuz.databinding.ActivitySelectCategoryBinding
import uz.devapp.elonuz.utils.Constants
import uz.devapp.elonuz.utils.PrefUtils

class SelectCategoryActivity : AppCompatActivity(),CategoryAdapterCallback {
    lateinit var binding: ActivitySelectCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySelectCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rv.adapter= CategoryAdapter(PrefUtils.getCategories(),this)
    }

    override fun onSelectCategory(item: CategoryModel) {
        EventBus.getDefault().post(EventModel(Constants.EVENT_SELECT_CATEGORY,item))
        finish()
    }
}