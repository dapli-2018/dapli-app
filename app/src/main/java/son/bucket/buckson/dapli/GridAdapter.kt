package son.bucket.buckson.dapli

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.grid_items.view.*

class GridAdapter (val context: Context, val gridData: ArrayList<GridData>) : BaseAdapter()
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val grid = gridData[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var gridView = inflator.inflate(R.layout.grid_items, null)

        val resourceId = context.resources.getIdentifier(grid.photo, "drawable", context.packageName)
        Log.d("Feed", "ID : " + resourceId)
        gridView.memImg?.setImageResource(resourceId)
        gridView.memTitle?.text = grid.title

        return gridView
    }

    override fun getItem(position: Int) = gridData[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = gridData.size

}