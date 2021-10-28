import java.io.File
import java.util.Properties

object PropertyUtil {
    private const val FILE_PROPERTIES = "config.properties"

    private const val DEBUG_STORE_FILE = "debug.store.file"
    private const val DEBUG_STORE_PASSWORD = "debug.store.password"
    private const val DEBUG_KEY_ALIAS = "debug.key.alias"
    private const val DEBUG_KEY_PASSWORD = "debug.key.password"

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

    fun getDebugStoreFilePath() : String = gradleFile().getProperty(DEBUG_STORE_FILE) ?: ""
    fun getDebugStorePassword() : String = gradleFile().getProperty(DEBUG_STORE_PASSWORD) ?: ""
    fun getDebugKeyAlias() : String = gradleFile().getProperty(DEBUG_KEY_ALIAS) ?: ""
    fun getDebugKeyPassword() : String = gradleFile().getProperty(DEBUG_KEY_PASSWORD) ?: ""
    fun getKakaoApiNativeKey() : String = gradleFile().getProperty(KAKAO_API_NATIVE_KEY) ?: ""
}