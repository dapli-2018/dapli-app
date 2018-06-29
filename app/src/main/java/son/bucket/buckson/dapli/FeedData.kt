package son.bucket.buckson.dapli

class FeedData(val title: String, val text: String, val photo: Int, val likes: String)

object FeedService{
    val FeedData = arrayListOf(
            FeedData("치앙마이 여행", "쪄죽을뻔 했지만 그래도 친구들과 드라이빙 하면서 좋은 시간을 보낸것 같다.", R.drawable.profile, "10002"),
            FeedData("Marvin Gaye", "Charlie Puth", R.drawable.profile, "12312"),
            FeedData("MIC DROP", "BTS", R.drawable.profile,"11551")
    )

    fun addData(data: FeedData) {
        FeedData.add(data)
    }
}
