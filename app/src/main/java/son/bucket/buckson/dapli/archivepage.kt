package son.bucket.buckson.dapli

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class archivepage : Fragment() {

    lateinit var viewPager: ViewPager
    val manager = this.activity.supportFragmentManager

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        Log.d("LIST", "createview")
        return inflater!!.inflate(R.layout.music_list, null)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var viewPagerAdapter = pagerAdapter(manager)
        viewPagerAdapter.addFrag(repo())
        Log.d("main","size: " + viewPagerAdapter.count)
        viewPager = this.activity.findViewById(R.id.gridviewPager)
    }
}