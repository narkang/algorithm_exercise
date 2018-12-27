package com.narkang.socket

object MessageCreator {

    private const val SN_HEADER = "收到暗号，我是（SN）:"
    private const val PORT_HEADER = "这是暗号，请回电端口（Port）:"

    fun buildWithPort(port: Int) = PORT_HEADER + port

    fun parsePort(data: String): Int{
        if(data.startsWith(PORT_HEADER)){
            return data.substring(PORT_HEADER.length).toInt()
        }
        return -1
    }

    fun buildWithSn(sn: String) = SN_HEADER + sn

    fun parseSn(data: String): String?{

        if(data.startsWith(SN_HEADER)){
            return data.substring(SN_HEADER.length)
        }

        return null
    }

}