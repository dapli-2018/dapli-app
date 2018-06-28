#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_son_bucket_buckson_dapli_main_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
