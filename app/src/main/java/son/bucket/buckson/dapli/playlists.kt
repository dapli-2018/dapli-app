package son.bucket.buckson.dapli

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log

class playlists : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_playlists)

        var viewPagerAdapter = pagerAdapter(manager)
        viewPagerAdapter.addFrag(list())
        Log.d("main","size: " + viewPagerAdapter.count)
        viewPager = findViewById(R.id.viewPager)
    }
}
