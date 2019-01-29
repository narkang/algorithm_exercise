/**
 * 翻转单词顺序
 *
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 举例说明
 * 例如输入字符串”I am a student. ”，则输出”student. a am I”。
 */
fun main(args: Array<String>) {
    val str = "I am a student. "
    println(reverseSentence(str))
}

/**
 * 题目一：输入一个英文句子，翻转句子中单词的顺序，但单词内字啊的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 */
fun reverseSentence(_data: String): String{
    var data = _data
    data = reverse(data, 0, data.length-1)

    var start = 0
    var end = 0

    while (start < data.length){
        if(data[start] == ' '){
            start ++
            end ++
        }else if(end == data.length|| data[end] == ' '){
            data = reverse(data, start, end-1)
            end++
            start = end
        }else{
            end ++
        }
    }

    return data
}

/**
 *  反转字符串
 */
fun reverse(str: String, _start: Int, _end: Int): String{

    val start = _start
    val end = _end

    if(start < 0 || end > str.length){
        return str
    }

    val sb = StringBuffer()

    if(start > 0){
        for (i in 0 until start){
            sb.append(str[i])
        }
    }

    for(i in end downTo start){
        sb.append(str[i])
    }

    if(end+1 < str.length){
        for (i in end+1 until str.length){
            sb.append(str[i])
        }
    }

    return sb.toString()

}