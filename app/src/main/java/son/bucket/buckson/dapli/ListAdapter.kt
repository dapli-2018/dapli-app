package son.bucket.buckson.dapli

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter (val context: Context, val musicData: ArrayList<MusicData>) : BaseAdapter()
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val musicView: View
        val holder : ViewHolder

        if(convertView == null) {
            musicView = LayoutInflater.from(context).inflate(R.layout.music_list_item, null)
            holder = ViewHolder()
            holder.musicName = musicView.findViewById(R.id.musicName)
            holder.musicSinger = musicView.findViewById(R.id.musicSinger)
            holder.musicThumbnail = musicView.findViewById(R.id.musicThumbnail)

            musicView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            musicView = convertView
        }

        val msc = musicData[position]

        val resourceId = context.resources.getIdentifier(msc.photo, "drawable", context.packageName)
        Log.d("Resource", "ID : " + resourceId)
        holder.musicThumbnail?.setImageResource(resourceId)
        holder.musicName?.text = msc.name
        holder.musicSinger?.text = msc.singer

        return musicView
    }

    override fun getItem(position: Int) = musicData[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = musicData.size

    private class ViewHolder {
        var musicName : TextView? = null
        var musicSinger : TextView? = null
        var musicThumbnail : ImageView? = null
    }
}