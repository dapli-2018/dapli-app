package son.bucket.buckson.dapli

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GridAdapter (val context: Context, val gridData: ArrayList<GridData>) : BaseAdapter()
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val gridView: View
        val holder : ViewHolder

        if(convertView == null) {
            gridView = LayoutInflater.from(context).inflate(R.layout.archive_list, null)
            holder = ViewHolder()
            holder.memTitle = gridView.findViewById(R.id.memTitle)
            holder.memImg = gridView.findViewById(R.id.memImg)

            gridView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            gridView = convertView
        }

        val msc = gridData[position]

        val resourceId = context.resources.getIdentifier(msc.photo, "drawable", context.packageName)
        holder.memImg?.setImageResource(resourceId)
        holder.memTitle?.text = msc.title

        return gridView
    }

    override fun getItem(position: Int) = gridData[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = gridData.size

    private class ViewHolder {
        var memTitle : TextView? = null
        var memImg : ImageView? = null
    }
}