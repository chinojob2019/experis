package christian.loayza.retoexperis.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import christian.loayza.retoexperis.R
import christian.loayza.retoexperis.domain.model.Place
import christian.loayza.retoexperis.ui.helpers.load

class PlaceAdapter (
    private var places: List<Place?>,
    private val itemClick: (Place?) -> Unit
): RecyclerView.Adapter<PlaceAdapter.ViewHolder>()
{


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_places, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = places[position]

        item?.let { place ->

            with(holder){
                title.text = place.title
                description.text = place.description
                imageView.load(place.photo)
                itemView.setOnClickListener { itemClick(place) }
            }
        }
    }

    override fun getItemCount(): Int = places.size
    fun updateRecipes(filteredList: List<Place?>) {
        places = filteredList
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.ivItemImage)
        val title: TextView = view.findViewById(R.id.tvTitle)
        val description: TextView = view.findViewById(R.id.tvDetails)

    }

}