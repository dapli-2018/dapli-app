package son.bucket.buckson.dapli

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import kotlinx.android.synthetic.main.archive_grid.*

class repo : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.d("HOME", "createview")
        return inflater!!.inflate(R.layout.archive_grid, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.d("HOME", "adapter")
        var gridAdapter = GridAdapter(context, GridService.GridData)
        myGridView.adapter = gridAdapter
        (this.activity.findViewById(R.id.PickPhoto) as ImageButton).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(context, mylists::class.java)
                startActivity(intent)
            }
        })
    }
}
