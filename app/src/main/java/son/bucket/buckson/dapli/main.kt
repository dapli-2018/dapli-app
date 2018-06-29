package son.bucket.buckson.dapli

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class main : AppCompatActivity() {

    val manager = supportFragmentManager
    var idx = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ShowHomeFeed()

        //var musicAdapter = ListAdapter(this, DataService.MusicData)
        //myListView.adapter = musicAdapter

        //var gridAdapter = GridAdapter(this, GridService.GridData)
        //myGridView.adapter = gridAdapter
    }

    fun ShowHomeFeed() {
        val transaction = manager.beginTransaction()

        transaction.replace(R.id.myListView, home())
        transaction.addToBackStack("home")
        transaction.commit()
        idx = 0
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