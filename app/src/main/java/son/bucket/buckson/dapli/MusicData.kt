package son.bucket.buckson.dapli

class MusicData(val name: String, val singer: String, val photo: String)

object DataService{
    val MusicData = arrayListOf(
            MusicData("Forever Young", "BLACK PINK", "ddududdudu"),
            MusicData("LATATA", "(girl)IDLE", "latata"),
            MusicData("Marvin Gaye", "Charlie Puth", "marvingaye"),
            MusicData("MIC DROP", "BTS", "micdrop"),
            MusicData("Stars", "ROTHY", "stars")
    )
}