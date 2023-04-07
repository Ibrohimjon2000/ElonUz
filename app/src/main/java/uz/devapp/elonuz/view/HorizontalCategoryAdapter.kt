package uz.devapp.elonuz.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.devapp.elonuz.data.models.CategoryModel
import uz.devapp.elonuz.databinding.CategoryItemLayoutBinding
import uz.devapp.elonuz.utils.loadImage

class HorizontalCategoryAdapter(val items:List<CategoryModel>):RecyclerView.Adapter<HorizontalCategoryAdapter.Vh>() {
    inner class Vh(val binding: CategoryItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(CategoryItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        val categoryModel = items[position]
        holder.binding.tvCategory.text=categoryModel.title
        holder.binding.imgCategory.loadImage(categoryModel.image)
    }
}