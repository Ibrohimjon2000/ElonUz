package uz.devapp.elonuz.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import uz.devapp.elonuz.R
import uz.devapp.elonuz.data.models.AdsModel
import uz.devapp.elonuz.data.models.CategoryModel
import uz.devapp.elonuz.databinding.FragmentMainBinding
import uz.devapp.elonuz.view.AdsAdapter
import uz.devapp.elonuz.view.HorizontalCategoryAdapter

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentMainBinding.inflate(inflater,container,false)
        binding.apply {
            viewModel=ViewModelProvider(this@MainFragment)[MainViewModel::class.java]

            viewModel.errorLiveData.observe(requireActivity()){
                Toast.makeText(requireActivity(), it, Toast.LENGTH_SHORT).show()
            }

            viewModel.progressLiveData.observe(requireActivity()){
                swipe.isRefreshing=it
            }

            swipe.setOnRefreshListener {
                loadData()
            }

            viewModel.categoriesListLiveData.observe(requireActivity()){
                rvCategory.adapter=HorizontalCategoryAdapter(it)
            }

            rvAds.adapter=AdsAdapter(listOf(
                AdsModel(1,"Samsung Galaxy S23 Ultra","upload/category/image/jxVkh0GY2bKHZvBsIJFV.png","Yaxshi","Fergana","+998911175920",1200000.0,listOf("")),
                AdsModel(1,"Samsung Galaxy S23 Ultra","upload/category/image/jxVkh0GY2bKHZvBsIJFV.png","Yaxshi","Fergana","+998911175920",1200000.0,listOf("")),
                AdsModel(1,"Samsung Galaxy S23 Ultra","upload/category/image/jxVkh0GY2bKHZvBsIJFV.png","Yaxshi","Fergana","+998911175920",1200000.0,listOf("")),
                AdsModel(1,"Samsung Galaxy S23 Ultra","upload/category/image/jxVkh0GY2bKHZvBsIJFV.png","Yaxshi","Fergana","+998911175920",1200000.0,listOf("")),
                AdsModel(1,"Samsung Galaxy S23 Ultra","upload/category/image/jxVkh0GY2bKHZvBsIJFV.png","Yaxshi","Fergana","+998911175920",1200000.0,listOf("")),
                AdsModel(1,"Samsung Galaxy S23 Ultra","upload/category/image/jxVkh0GY2bKHZvBsIJFV.png","Yaxshi","Fergana","+998911175920",1200000.0,listOf("")),
                AdsModel(1,"Samsung Galaxy S23 Ultra","upload/category/image/jxVkh0GY2bKHZvBsIJFV.png","Yaxshi","Fergana","+998911175920",1200000.0,listOf("")),
                AdsModel(1,"Samsung Galaxy S23 Ultra","upload/category/image/jxVkh0GY2bKHZvBsIJFV.png","Yaxshi","Fergana","+998911175920",1200000.0,listOf("")),
                AdsModel(1,"Samsung Galaxy S23 Ultra","upload/category/image/jxVkh0GY2bKHZvBsIJFV.png","Yaxshi","Fergana","+998911175920",1200000.0,listOf("")),
                AdsModel(1,"Samsung Galaxy S23 Ultra","upload/category/image/jxVkh0GY2bKHZvBsIJFV.png","Yaxshi","Fergana","+998911175920",1200000.0,listOf("")),
            ))
            loadData()
        }
        return binding.root
    }

    fun loadData(){
        viewModel.getCategories()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}