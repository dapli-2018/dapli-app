package son.bucket.buckson.dapli

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log

class main : AppCompatActivity() {

    lateinit var viewPager: ViewPager
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var viewPagerAdapter = pagerAdapter(manager)
        viewPagerAdapter.addFrag(home())
        //viewPagerAdapter.addFrag(list())
        viewPagerAdapter.addFrag(repo())
        Log.d("main","size: " + viewPagerAdapter.count)
        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = viewPagerAdapter
        //var musicAdapter = ListAdapter(this, DataService.MusicData)
        //myListView.adapter = musicAdapter

        //var gridAdapter = GridAdapter(this, GridService.GridData)
        //myGridView.adapter = gridAdapter
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {

        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}