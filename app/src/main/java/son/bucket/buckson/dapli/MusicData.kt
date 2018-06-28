package son.bucket.buckson.dapli

class MusicData(val name: String, val singer: String, val photo: String) {
}

object DataService{
    val MusicData = arrayListOf(
            MusicData("LATATA", "(girl)IDLE", "Jacket_latata"),
            MusicData("Marvin Gaye", "Charlie Puth", "Jacket_marvingaye"),
            MusicData("MIC DROP", "BTS", "Jacket_micdrop"),
            MusicData("Stars", "ROTHY", "Jacket_stars"),
            MusicData("DDU-DU DDU-DU", "BLACK PINK", "Jacket_ddududdudu")
    )
}