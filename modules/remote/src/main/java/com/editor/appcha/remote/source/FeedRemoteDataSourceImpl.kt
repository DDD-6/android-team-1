package com.editor.appcha.remote.source

import com.editor.appcha.core.arch.Result
import com.editor.appcha.core.arch.mapper.toData
import com.editor.appcha.data.model.AppData
import com.editor.appcha.data.model.FeedData
import com.editor.appcha.data.model.FeedDetailData
import com.editor.appcha.data.source.FeedRemoteDataSource
import com.editor.appcha.remote.grpc.Grpc
import com.editor.appcha.remote.model.AppRemote
import com.editor.appcha.remote.model.FeedDetailRemote
import com.editor.appcha.remote.model.FeedDetailRemote.Body
import kotlinx.coroutines.delay
import javax.inject.Inject

internal class FeedRemoteDataSourceImpl @Inject constructor(
    grpc: Grpc
) : FeedRemoteDataSource {

    // TODO: 서버 구현
    override suspend fun getFeeds(): Result<List<FeedData>> = Result.success(feeds)

    override suspend fun getFeed(feedId: String): Result<FeedDetailData> {
        val sampleDetail = when (feedId) {
            "1" -> kidDetail
            "2" -> interiorDetail
            "3" -> carDetail
            else -> kidDetail
        }

        return Result.success(
            sampleDetail
        ).toData()
            .onSuccess { delay(1000L) }
    }

    override suspend fun updateFavorite(feedId: String, isFavorite: Boolean): Result<Unit> =
        Result.success(Unit)
}


private val feeds = listOf(
    FeedData(
        id = "1",
        title = "바른 소통을 위한 우리 원의\n특별한 공간",
        author = "키즈노트",
        "혹시 아직도 종이 알림장이나 메신저로 부모님과 연락하세요?",
        imageUrl = "https://user-images.githubusercontent.com/58249793/143603733-5f5ccdda-f119-4d30-8640-7e070fadd5d5.png",
        apps = emptyList()
    ),
    FeedData(
        id = "2",
        title = "최고의 가구를 찾아서",
        author = "에디터 루디",
        "",
        imageUrl = "https://user-images.githubusercontent.com/58249793/143603742-0ae9db37-e860-4a60-83dc-401c6615e697.png",
        apps = listOf(
            AppData(
                id = "1",
                name = "오늘의집 - 2000만이 선택한 인테리어",
                description = "예쁜 집 구경이 인테리어의 시작! 집 꾸미기 가이드, 지금 바로 시작하세요.",
                imageUrl = "https://user-images.githubusercontent.com/58249793/143603854-25b8d9d9-f105-47c7-813f-b90be1c8da53.png",
                marketUrl = "net.bucketplace"
            ),
            AppData(
                id = "2",
                name = "IKEA Place",
                description = "Spark ideas to create a better life at home.",
                imageUrl = "https://user-images.githubusercontent.com/58249793/143603856-5a738f96-2223-48cd-8533-2dc96e586a7c.png",
                marketUrl = "com.ingka.ikea.app"
            ),
            AppData(
                id = "3",
                name = "집꾸미기 - No.1 인테리어 가이드",
                description = "인테리어 팁, 정보부터 최저가 쇼핑까지",
                imageUrl = "https://user-images.githubusercontent.com/58249793/143603865-8e704f18-9a5f-4367-85b8-8b61ca0dc467.png",
                marketUrl = "com.osquare.mydearnest"
            )
        )
    ),
    FeedData(
        id = "3",
        title = "사고 팔고 빌리고\n차에 대한 모든 것",
        author = "엔진오일",
        "자동차와 관련된 모든 것들을 담았습니다. 여러분께는 어떤 앱이 필요하신가요?",
        imageUrl = "https://user-images.githubusercontent.com/58249793/143610417-f0322db6-2ad7-492c-9bd9-ada48b8fdc69.png",
        apps = emptyList()
    ),
    FeedData(
        id = "4",
        title = "가슴이 웅장해지는\n쿠키들의 세계",
        author = "쿠키커터",
        "확장된 쿠키런 세계관, 마녀의 오븐에서 탈출하고 도착한 곳은 고대 부흥했던 쿠키 왕국!",
        imageUrl = "https://user-images.githubusercontent.com/58249793/143603759-4b04e64c-75b4-4e5c-9a39-a3dac3ba7f1c.png",
        apps = emptyList()
    ),
    FeedData(
        id = "5",
        title = "트렌치코트를 사고 싶다면?",
        author = "MD 오취리",
        "어디서든 눈길을 끌만한 트렌디한 트렌치코트를 만나보세요.",
        imageUrl = "https://user-images.githubusercontent.com/58249793/143603760-8764aea3-174f-4c46-a1fd-561f7dfbe9c2.png",
        apps = listOf(
            AppData(
                id = "1",
                name = "20CM",
                description = "라이프스타일, 트렌드 쇼핑과 할인",
                imageUrl = "https://user-images.githubusercontent.com/58249793/143604295-5a588361-c7cc-4d37-989b-8d169de7c9f2.png",
                marketUrl = null
            ),
            AppData(
                id = "2",
                name = "지그재그 - 내 맘대로 쇼핑앱",
                description = "3천만이 선택한 국민 쇼핑앱",
                imageUrl = "https://user-images.githubusercontent.com/58249793/143604302-f1c9ef2f-fc71-4020-b7f7-095b59ff3add.png",
                marketUrl = null
            ),
            AppData(
                id = "3",
                name = "W컨셉",
                description = "온라인 패션 플랫폼",
                imageUrl = "https://user-images.githubusercontent.com/58249793/143604310-99634a15-afc0-4168-9fef-d06a330c9bf9.png",
                marketUrl = null
            )
        )
    )
)

private val kidDetail = FeedDetailRemote(
    id = "id",
    title = "바른 소통을 위한 우리 원의\n특별한 공간",
    author = "키즈노트",
    imageUrl = "https://user-images.githubusercontent.com/58249793/143605879-bcdbe945-b0c2-4e6a-911b-91078ca7b417.png",
    summary = "혹시 아직도 종이 알림장이나 메신저로 부모님과 연락하세요?",
    bodies = listOf(
        Body.Text("혹시 아직도 종이 알림장이나 메신저로 부모님과 연락하세요? 원 운영과 관리를 효율적으로, 학부모의 만족도는 최대로 높일 수 있는 가장 쉬운 방법을 알려드립니다. 어린이집 두 곳 중 한 곳은 이미 사용중이라는 키즈노트!"),
        Body.Image("https://user-images.githubusercontent.com/58249793/143606368-931b6d71-26b9-4af7-9393-a5d6c186b1e4.png"),
        Body.Text("우리 원의 경쟁력을 높여주는 스마트 알림장을 이용해보는건 어떨까요? 키즈노트의 핵심 기능을 알려드립니다."),
        Body.Image("https://user-images.githubusercontent.com/58249793/143606372-d11f3969-330d-4f1f-bbc5-70f347fd960f.png"),
        Body.Text("1:1 알림장으로 학부모님과 소통할 수 있으며 맞춤법 검사로 걱정없이 사용할 수 있습니다. 수신확인 기능이 탑재된 공지사항 기능으로 공지를 확인하지 않은 부모에게 다시 알림을 발송할 수 있습니다. 사진, 알림장, 댓글까지 모두 한데모아 포토북을 만들 수 있습니다. 우리 원의 스마트한 경쟁력을 높여줄 <키즈노트>. 오늘 이용해보시는건 어떠세요?"),
        Body.Apps(
            apps = listOf(
                AppRemote(
                    id = "1",
                    name = "키즈노트::유치원, 어린이집",
                    description = "교육기관을 위한 특별한 소통 공간",
                    imageUrl = "https://user-images.githubusercontent.com/58249793/143606373-b0c95809-f021-456d-8c13-07c8f10a5863.png",
                    marketUrl = "com.vaultmicro.kidsnote"
                )
            )
        )
    ),
    isFavorite = false
)

private val interiorDetail = FeedDetailRemote(
    id = "id",
    title = "최고의 가구를 찾아서",
    author = "에디터 루디",
    imageUrl = "https://user-images.githubusercontent.com/58249793/143605905-38f0cf6d-a4a4-4dd8-b2c9-49b738e22afa.png",
    summary = "가구는 삶에서 중요한 요소를 차지합니다. 집에 어떤 가구를 배치하는지는 어떤 옷을 입고 외출하느냐와 같은 문제죠.",
    bodies = listOf(
        Body.Text("파면 팔수록 깊고 넓어지는 가구의 세계. 마음에 쏙 드는 서랍장을 발견했지만 막상 집에 들이면 벽지, 바닥, 다른 가구와 어울릴지 감이 오지 않는 경험 있지 않으신가요? 이럴 땐 고수들의 인테리어나 상세 정보를 통해 아이디어를 얻어야하죠! 공감하신다면 아래의 앱들을 통해 성공적인 가구를 들이세요."),
        Body.Image("https://user-images.githubusercontent.com/58249793/143606940-1a4dfd09-d847-4eed-a55e-8896599f4e0f.png"),
        Body.Text("<오늘의집>의 매력 포인트는 인테리어에 열정이 있는 수많은 사람들이 자신의 집을 소개하고 다양한 가구, 인테리어 소품, 팁들을 공유합니다."),
        Body.Image("https://user-images.githubusercontent.com/58249793/143606945-275f4beb-fa5f-43ae-976e-306a969beee7.png"),
        Body.Text("원하는 가구를 발견하고 치수도 완벽하게 맞았는데 막상 집에 들이니 치수가 맞지 않는 경험이 있지는 않나요? <Ikea Place>를 활용한다면 문제 없습니다. 방을 스캔하고 가구를 배치하고 요리조리 확인. 참 쉽죠?"),
        Body.Image("https://user-images.githubusercontent.com/58249793/143606953-d65ba3f9-4d4d-48ac-a6c1-87a8e67fc00c.png"),
        Body.Text("혹시 퀸즈갬빗 보셨나요? <집꾸미기>를 통해 퀸즈갬빗 스타일링을 구경해보는건 어떠신가요?  인테리어에 활용한 소품과 제작과정을 확인할 수 있으니 인테리어 아이디어가 샘솟을거예요."),
        Body.Apps(
            apps = listOf(
                AppRemote(
                    id = "1",
                    name = "오늘의집-2000만이 선택한 No,1 인테리어 플랫폼",
                    description = "예쁜 집 구경이 인테리어의 시작! 집 꾸미기 가이드",
                    imageUrl = "https://user-images.githubusercontent.com/58249793/143603854-25b8d9d9-f105-47c7-813f-b90be1c8da53.png",
                    marketUrl = "net.bucketplace"
                ),
                AppRemote(
                    id = "2",
                    name = "IKEA Place",
                    description = "Spark ideas to create a better life at home.",
                    imageUrl = "https://user-images.githubusercontent.com/58249793/143603856-5a738f96-2223-48cd-8533-2dc96e586a7c.png",
                    marketUrl = "com.ingka.ikea.app"
                ),
                AppRemote(
                    id = "3",
                    name = "집꾸미기 - No.1 인테리어 가이드",
                    description = "인테리어 팁, 정보부터 최저가 쇼핑까지",
                    imageUrl = "https://user-images.githubusercontent.com/58249793/143603865-8e704f18-9a5f-4367-85b8-8b61ca0dc467.png",
                    marketUrl = "com.osquare.mydearnest"
                )
            )
        )
    ),
    isFavorite = false
)

private val carDetail = FeedDetailRemote(
    id = "id",
    title = "사고 팔고 빌리고\n차에 대한 모든 것",
    author = "엔진오일",
    imageUrl = "https://user-images.githubusercontent.com/58249793/143610225-28f954ab-2678-4c2e-9acb-6a9c927d5fdc.png",
    summary = "자동차와 관련된 모든 것들을 담았습니다. 여러분께는 어떤 앱이 필요하신가요?",
    bodies = listOf(
        Body.Text("차 사실 계획이 있으신가요? 자차를 생각중이라면 중고차는 어떠신가요? 여행가서 렌트할 예정이신가요? 잘 찾아오셨습니다!"),
        Body.Image("https://user-images.githubusercontent.com/58249793/143610250-aa7777f6-5471-4492-80cb-644abdd6eb70.png"),
        Body.Text("여행가기 전 <쏘카>로 미리 예약해두는건 어떨까요? 3달 전부터 최대 28일까지 예약이 가능합니다. 4,000여 개 쏘카존 혹은 원하는 곳으로 불러 이용 가능해 효율적입니다."),
        Body.Image("https://user-images.githubusercontent.com/58249793/143610256-6bfc76e1-4244-4985-b326-feb99bd45e3f.png"),
        Body.Text("중고차 판매플랫폼 브랜드 선호도 1위의 주인공<헤이딜러>입니다. 매월 5만여 대 의 경매 출품이 이루어지는 만큼 다양한 중고차 정보와 후기가 기록되어있습니다."),
        Body.Apps(
            apps = listOf(
                AppRemote(
                    id = "1",
                    name = "헤이딜러",
                    description = "내차시세, 내차팔기 필수앱",
                    imageUrl = "https://www.theteams.kr/includes/uploads/company_profile/PRNDCompany.png",
                    marketUrl = "kr.perfectree.heydealer"
                ),
                AppRemote(
                    id = "2",
                    name = "쏘카 - 차가 필요한 모든 순간",
                    description = "언제, 어디서나 필요한 만큼 쏘카와 함께하세요.",
                    imageUrl = "https://user-images.githubusercontent.com/58249793/143609438-c8b9f40e-1edd-41c9-a048-92712b4f9098.png",
                    marketUrl = "socar.Socar"
                )
            )
        )
    ),
    isFavorite = false
)
