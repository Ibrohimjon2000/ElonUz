package uz.devapp.elonuz.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.devapp.elonuz.data.models.AdsModel
import uz.devapp.elonuz.databinding.AdsItemLayoutBinding
import uz.devapp.elonuz.utils.loadImage

class AdsAdapter(val items: List<AdsModel>) : RecyclerView.Adapter<AdsAdapter.Vh>() {
    inner class Vh(val binding: AdsItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(AdsItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        val adsModel = items[position]
        holder.binding.imgAds.loadImage(adsModel.mainImage)
        holder.binding.tvName.text = adsModel.name
        holder.binding.tvAddress.text = adsModel.address
        holder.binding.tvPrice.text = "${adsModel.price} UZS"
    }
}