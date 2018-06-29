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
        /*viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                if(position==0) findViewById<ImageView>(R.id.thisCount).setImageResource(R.drawable.home_button)
                if(position==1) findViewById<ImageView>(R.id.thisCount).setImageResource(R.drawable.archive_button)
                //if(position==0) findViewById<ImageView>(R.id.thisCount).setImageResource(R.drawable.home_button)
            }

            override fun onPageSelected(position: Int) {
            }
        })*/
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