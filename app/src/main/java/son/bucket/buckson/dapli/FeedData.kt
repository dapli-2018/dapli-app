package son.bucket.buckson.dapli

class FeedData(val title: String, val text: String, val photo: String, val likes: String, val hashTag: String, val picks: String, val name: String)

object FeedService{
    val FeedData = arrayListOf(
            FeedData("치앙마이 여행", "쪄죽을뻔 했지만 그래도 친구들과 드라이빙 하면서 좋은 시간보내따~~~ 개꿀잼 개이득~~~ 다음 여행은 어디가지??? 추천받음 ㄱㄱㄱ", "sin", "10", "#태국 #우정여행 #치앙마이", "6", "신수철"),
            FeedData("해커톤 플레이리스트", "해커톤 플레이리스트입니다~ 아무나 들어와도됨.. 선곡 제대로 해줘용 ㅠㅠ 아니묜!! 내귀 ㅠㅠㅠㅠㅠ", "sin", "120","#해커톤 #드루와", "12", "신수철"),
            FeedData("재워주세요 제발", "잠을 못자고 이따.. 졸려죽게따..", "profile","11", "#해커톤 #피곤해","6", "다플리")
    )

    fun addData(data: FeedData) {
        FeedData.add(data)
    }
}
