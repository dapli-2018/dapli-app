package son.bucket.buckson.dapli

class FeedData(val title: String, val text: String, val photo: String)

object FeedService{
    val FeedData = arrayListOf(
            FeedData("LATATA", "(girl)IDLE", "Jacket_latata"),
            FeedData("Marvin Gaye", "Charlie Puth", "marvingaye"),
            FeedData("MIC DROP", "BTS", "Jacket_micdrop"),
            FeedData("Stars", "ROTHY", "Jacket_stars"),
            FeedData("DDU-DU DDU-DU", "BLACK PINK", "Jacket_ddududdudu")
    )
}
