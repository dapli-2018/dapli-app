package son.bucket.buckson.dapli

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class FeedAdapter (val context: Context, val feedData: ArrayList<FeedData>) : BaseAdapter()
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val feed: View
        val holder : ViewHolder

        if(convertView == null) {
            feed = LayoutInflater.from(context).inflate(R.layout.mainfeed, null)
            holder = ViewHolder()
            holder.memoryTitle = feed.findViewById(R.id.memoryTitle)
            holder.memoryDesc = feed.findViewById(R.id.memoryDescirpt)
            holder.memoryLikes = feed.findViewById(R.id.likesNum)
            holder.profileImage = feed.findViewById(R.id.musicThumbnail)

            feed.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            feed = convertView
        }

        val msc = feedData[position]

        val resourceId = context.resources.getIdentifier(msc.photo, "drawable", context.packageName)
        holder.profileImage?.setImageResource(resourceId)
        holder.memoryTitle?.text = msc.title
        holder.memoryDesc?.text = msc.text
        holder.memoryLikes?.text = msc.likes

        return feed
    }

    override fun getItem(position: Int) = feedData[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = feedData.size

    private class ViewHolder {
        var memoryTitle : TextView? = null
        var memoryDesc : TextView? = null
        var memoryLikes : TextView? = null
        var profileImage : ImageView? = null
    }
}