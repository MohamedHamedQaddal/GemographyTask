package eg.gov.iti.jets.task

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import eg.gov.iti.jets.task.databinding.RecyclerviewRowBinding

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var items = ArrayList<RecyclerData>()

    fun setDataList(data :  ArrayList<RecyclerData>) {
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = eg.gov.iti.jets.task.databinding.RecyclerviewRowBinding.inflate(layoutInflater)
        return MyViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class MyViewHolder(val binding: RecyclerviewRowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: RecyclerData) {
            binding.recyclerData = data
            binding.executePendingBindings()
        }
    }

    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(thumbImage: ImageView, url: String) {
            Glide.with(thumbImage)
                .load(url)
                //.circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(thumbImage)
        }
    }
}