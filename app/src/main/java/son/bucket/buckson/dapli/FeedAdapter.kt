package son.bucket.buckson.dapli

import android.content.Context
import android.content.Intent
import android.util.Log
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

        //FeedService.addData(FeedData("후..", "아피곤하다", R.drawable.profile,"115", "6", "신수철"))

        if(convertView == null) {
            feed = LayoutInflater.from(context).inflate(R.layout.feed_info, null)
            holder = ViewHolder()
            holder.memoryTitle = feed.findViewById(R.id.memoryTitle)
            holder.memoryDesc = feed.findViewById(R.id.memoryDescirpt)
            holder.memoryLikes = feed.findViewById(R.id.likesNum)
            holder.profileImage = feed.findViewById(R.id.profile)
            holder.pickNums = feed.findViewById(R.id.pickNum)
            holder.profileName = feed.findViewById(R.id.userName)
            holder.hashtags = feed.findViewById(R.id.hashTag)

            feed.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            feed = convertView
        }

        val fd = feedData[position]

        val resourceId = context.resources.getIdentifier(fd.photo, "drawable", context.packageName)
        holder.profileImage?.setImageResource(resourceId)
        //holder.profileImage?.
        holder.memoryTitle?.text = fd.title
        holder.memoryDesc?.text = fd.text
        holder.memoryLikes?.text = fd.likes
        holder.pickNums?.text = fd.picks
        holder.profileName?.text = fd.name
        holder.hashtags?.text = fd.hashTag

        feed.setOnClickListener(object : View.OnClickListener {
            internal var buttonClickFlag: Boolean = false

            override fun onClick(v: View?) {
                val intent = Intent(context, lists::class.java)
                context.startActivity(intent)
                Log.d("CLICK", "ID : " +  feedData[position].name)
            }
        })

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
        var profileName : TextView? = null
        var hashtags : TextView? = null
        var pickNums : TextView? = null
    }
}