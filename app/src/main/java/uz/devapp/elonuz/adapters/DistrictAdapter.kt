package uz.devapp.elonuz.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.greenrobot.eventbus.EventBus
import uz.devapp.elonuz.data.models.DistrictModel
import uz.devapp.elonuz.data.models.EventModel
import uz.devapp.elonuz.data.models.RegionModel
import uz.devapp.elonuz.databinding.DistrictItemLayoutBinding
import uz.devapp.elonuz.databinding.RegionItemLayoutBinding
import uz.devapp.elonuz.utils.Constants
import uz.devapp.elonuz.utils.loadImage

class DistrictAdapter(val items: List<DistrictModel>,val callback: RegionAdapterCallback) : RecyclerView.Adapter<DistrictAdapter.Vh>() {
    inner class Vh(val binding: DistrictItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            DistrictItemLayoutBinding.inflate(
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
            callback.onSelectDistrict(item)
        }
        holder.binding.tvName.text=item.nameUz
    }
}