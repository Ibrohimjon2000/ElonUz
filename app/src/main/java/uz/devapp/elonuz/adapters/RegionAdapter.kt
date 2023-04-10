package uz.devapp.elonuz.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.devapp.elonuz.R
import uz.devapp.elonuz.data.models.DistrictModel
import uz.devapp.elonuz.data.models.RegionModel
import uz.devapp.elonuz.databinding.RegionItemLayoutBinding
import uz.devapp.elonuz.utils.loadImage

interface RegionAdapterCallback {
    fun onSelectDistrict(item: DistrictModel)
}

class RegionAdapter(val items: List<RegionModel>, val callback: RegionAdapterCallback) :
    RecyclerView.Adapter<RegionAdapter.Vh>() {
    inner class Vh(val binding: RegionItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            RegionItemLayoutBinding.inflate(
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

        holder.binding.lyRegion.setOnClickListener {
            items.forEach { it.active = false }
            item.active = true
            notifyDataSetChanged()
        }
        holder.binding.tvName.text = item.nameUz
        holder.binding.rv.adapter = DistrictAdapter(item.districts, callback)
        holder.binding.rv.visibility = if (item.active) View.VISIBLE else View.GONE
    }
}