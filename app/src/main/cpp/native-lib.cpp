//
// Created by User on 7/5/2022.
//
#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring
Java_com_example_securekey_Application_getPublicKey(JNIEnv *env, jobject object) {
    std::string hello = "long_public_key";
    return env->NewStringUTF(hello.c_str());
}
extern "C" JNIEXPORT jstring
Java_com_example_securekey_Application_getPrivateKey(JNIEnv *env, jobject object) {
    std::string hello = "long_private_key";
    return env->NewStringUTF(hello.c_str());
}

