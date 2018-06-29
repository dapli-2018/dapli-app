package son.bucket.buckson.dapli

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class pagerAdapter(fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager)
{
    override fun getItem(position: Int): Fragment? {
        return null
    }

    override fun getCount(): Int {
        return 0
    }
}