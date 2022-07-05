#include <jni.h>
JNIEXPORT jstring JNICALL
Java_com_example_securekey_Application_getPublicKey(JNIEnv *env, jobject instance) {
    return (*env)->  NewStringUTF(env, "long_public_key");
}

JNIEXPORT jstring JNICALL
Java_com_example_securekey_Application_getPrivateKey(JNIEnv *env) {
    return (*env)->NewStringUTF(env, "long_private_key");
}