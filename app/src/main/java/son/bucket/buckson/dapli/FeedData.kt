package son.bucket.buckson.dapli

class FeedData(val title: String, val text: String, val photo: String, val likes: String)

object FeedService{
    val FeedData = arrayListOf(
            FeedData("LATATA", "(girl)IDLE", "Jacket_latata", "10002"),
            FeedData("Marvin Gaye", "Charlie Puth", "marvingaye", "12312"),
            FeedData("MIC DROP", "BTS", "Jacket_micdrop","11551"),
            FeedData("Stars", "ROTHY", "Jacket_stars","23456"),
            FeedData("DDU-DU DDU-DU", "BLACK PINK", "Jacket_ddududdudu", "11231")
    )
}
