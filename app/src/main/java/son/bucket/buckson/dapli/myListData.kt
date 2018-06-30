package son.bucket.buckson.dapli

class MyMusicData(val name: String, val singer: String, val photo: String)

object myService{
    val MyMusicData = arrayListOf(
            MyMusicData("Forever Young", "BLACK PINK", "ddududdudu"),
            MyMusicData("LATATA", "(girl)IDLE", "latata"),
            MyMusicData("Marvin Gaye", "Charlie Puth", "marvingaye"),
            MyMusicData("MIC DROP", "BTS", "micdrop"),
            MyMusicData("Stars", "ROTHY", "stars")
    )
}