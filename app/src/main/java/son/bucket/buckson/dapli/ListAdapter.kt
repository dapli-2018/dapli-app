package son.bucket.buckson.dapli

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter (val context: Context, val musicData: ArrayList<MusicData>) : BaseAdapter()
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val musicView: View = LayoutInflater.from(context).inflate(R.layout.music_list_item, null)

        val musicName: TextView = musicView.findViewById(R.id.musicName)
        val musicSinger: TextView = musicView.findViewById(R.id.musicSinger)
        val musicThumbnail: ImageView = musicView.findViewById(R.id.musicThumbnail)

        val msc = musicData[position]

        val resourceId = context.resources.getIdentifier(msc.photo, "drawable", context.packageName)
        musicThumbnail.setImageResource(resourceId)
        musicName.text = msc.name
        musicSinger.text = msc.singer

        return musicView
    }

    override fun getItem(position: Int): Any {
        return musicData[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return musicData.size
    }
}