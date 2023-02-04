import com.podmev.portuguese.data.other.PortugueseLocale

data class ExtendedPronounVerbForm(
    val brazilVersions: List<String>,
    val portugalVersions: List<String>,
) {
    fun getVersionsByLocale(portugueseLocale: PortugueseLocale) =
        when (portugueseLocale) {
            PortugueseLocale.BRAZIL -> brazilVersions
            PortugueseLocale.PORTUGAL -> portugalVersions
        }

    fun isEmpty(portugueseLocale: PortugueseLocale) =
        getVersionsByLocale(portugueseLocale).isEmpty()

    fun isNotEmpty(portugueseLocale: PortugueseLocale) = !isEmpty(portugueseLocale)
}

fun createExtendedFormGroupByString(str: String?): ExtendedPronounVerbForm? =
    if (str != null) ExtendedPronounVerbForm(listOf(str), listOf(str)) else null

