package son.bucket.buckson.dapli

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import java.text.FieldPosition

class ListAdapter (val context: Context, val musicData: ArrayList<MusicData>) : BaseAdapter()
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val musicView: View = LayoutInflater.from(context).inflate(R.layout.)

        return musicView
    }
}