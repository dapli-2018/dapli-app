package son.bucket.buckson.dapli

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.music_list.*

class list : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.d("LIST", "createview")
        return inflater!!.inflate(R.layout.music_list, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.d("LIST", "adapter")
        var musicAdapter = ListAdapter(context, DataService.MusicData)
        myListView.adapter = musicAdapter
        Log.d("LIST", "add adapter")
    }
}