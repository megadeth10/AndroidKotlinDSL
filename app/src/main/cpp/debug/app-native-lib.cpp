#include <jni.h>
#include <string>

extern "C" JNIEXPORT jobjectArray JNICALL
Java_com_dondeath_hometraining_Aaa_a(
        JNIEnv *env,
        jobject /* this */) {
    const int count = 2;
    std::string str[count] = {
            "app-array test1",
            "app-array test2"
    };

    jobjectArray joa = (jobjectArray) env->NewObjectArray(count,
                                                          env->FindClass("java/lang/String"),
                                                          env->NewStringUTF(""));

    for (int i = 0; i < count; i++) {
        char* c = const_cast<char*>(str[i].c_str());
        env->SetObjectArrayElement(joa, i, env->NewStringUTF(c));
    }
    return joa;
}


extern "C" JNIEXPORT jstring JNICALL
Java_com_dondeath_hometraining_Aaa_b(
        JNIEnv *env,
        jobject /* this */) {
    std::string string_test = "debug";
    return env->NewStringUTF(string_test.c_str());
}


