package com.yey.kotlq

class `5-Person单例` private constructor() {
    public var mPerson: `5-Person单例`? = null

    private object mHolder {
        val INSTANT = `5-Person单例`()
    }

    companion object Factory {
        fun getInstance(): `5-Person单例` {
            return mHolder.INSTANT
        }
    }
}


