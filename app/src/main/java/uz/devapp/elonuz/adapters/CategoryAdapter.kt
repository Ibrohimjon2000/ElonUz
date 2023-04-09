package uz.devapp.elonuz.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.devapp.elonuz.R
import uz.devapp.elonuz.data.models.CategoryModel
import uz.devapp.elonuz.data.models.DistrictModel
import uz.devapp.elonuz.data.models.RegionModel
import uz.devapp.elonuz.databinding.RegionItemLayoutBinding
import uz.devapp.elonuz.databinding.SelectCategoryItemLayoutBinding
import uz.devapp.elonuz.utils.loadImage

interface CategoryAdapterCallback {
    fun onSelectCategory(item: CategoryModel)
}

class CategoryAdapter(val items: List<CategoryModel>, val callback: CategoryAdapterCallback) :
    RecyclerView.Adapter<CategoryAdapter.Vh>() {
    inner class Vh(val binding: SelectCategoryItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            SelectCategoryItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        val item = items[position]

        holder.itemView.setOnClickListener {
            callback.onSelectCategory(item)
        }

        holder.binding.tvName.text = item.title
    }
}