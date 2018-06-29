package son.bucket.buckson.dapli

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.archive_list.*

class repo : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.d("HOME", "createview")
        return inflater!!.inflate(R.layout.archive_list, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.d("HOME", "adapter")
        var gridAdapter = GridAdapter(context, GridService.GridData)
        myGridView.adapter = gridAdapter
        Log.d("HOME", "add adapter")
    }
}