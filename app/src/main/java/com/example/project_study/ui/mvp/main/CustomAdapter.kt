import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.project_study.R
import com.example.project_study.data.objects.Recipe
import com.squareup.picasso.Picasso


class CustomAdapter(private val list: List<Recipe>, private val onClick: (Int) -> Unit) :
        RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.item_list, parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = list[position].name
        val url: String = list[position].images[0]
        Picasso.get().load(list[position].images[0]).into(holder.img);
        holder.itemLayout.setOnClickListener {
            //TODO поменять на иденификатор uuid
//            onClick.invoke(list[position].uuid)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text = view.findViewById<TextView>(R.id.recipe_text)
        var img=view.findViewById<ImageView>(R.id.ItemListImg)
//        val text2 = view.findViewById<TextView>(R.id.textView2)
        val itemLayout = view.findViewById<ConstraintLayout>(R.id.itemLayout)
    }

}
