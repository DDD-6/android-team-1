import java.io.File
import java.util.Properties

object PropertyUtil {
    private const val FILE_PROPERTIES = "config.properties"

    private const val KAKAO_API_NATIVE_KEY = "kakao.api.native.key"

    private fun gradleFile() : Properties {
        val gradleProperties = Properties()
        File(FILE_PROPERTIES).run {
            println("${exists()}")
            if(exists()) {
                gradleProperties.load(inputStream())
            }
        }
        return gradleProperties
    }

    fun getKakaoApiNativeKey() : String = gradleFile().getProperty(KAKAO_API_NATIVE_KEY) ?: ""
}