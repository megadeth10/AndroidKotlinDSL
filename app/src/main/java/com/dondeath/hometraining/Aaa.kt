package com.dondeath.hometraining

class Aaa {
    companion object {
        init {
            System.loadLibrary("app-native")
        }
    }


    /**
     * string array test
     */
    external fun a() : Array<String>

    /**
     * api host url
     */
    external fun b() : String
}