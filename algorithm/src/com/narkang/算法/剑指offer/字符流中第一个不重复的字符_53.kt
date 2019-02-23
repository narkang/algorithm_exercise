/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 举例说明
 * 例如，当从字符流中只读出前两个字符“Go”时，第一个只出现一次的字符是‘g’。当从该字符流中读出前六个字符“google”时，第一个只出现1次的字符是”l”。
 */
fun main(args: Array<String>) {

    val str = "google"
    var onceChar = firstAppearOnce(str)
    println("第一个不重复元素$onceChar")

}


/**
 *  第一次数组中只出现一次的字符
 */
private fun firstAppearOnce(str: String): Char{

    var charMap = LinkedHashMap<Char, Int>()
    val len = str.length

    for (i in 0 until len){
        if(charMap.containsKey(str[i])){
            var num = charMap[str[i]]
            num?.let { charMap[str[i]] = it+1 }
        }else{
            charMap[str[i]] = 1
        }
    }

    val keys = charMap.keys
    keys.forEach{
        if(charMap[it] == 1) return it
    }

    return '#'
}