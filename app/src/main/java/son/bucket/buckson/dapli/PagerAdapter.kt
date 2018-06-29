package son.bucket.buckson.dapli

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.util.Log

class pagerAdapter(fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager)
{
    val fragments = ArrayList<Fragment>()

    override fun getItem(position: Int): Fragment
    {
        Log.d("get", "ITEM: " + position)
        return fragments[position]
    }

    override fun getCount(): Int = fragments.size

    fun addFrag(frag: Fragment) {
        fragments.add(frag)
        Log.d("pagerAdapter","id:"+frag.id)
    }
}