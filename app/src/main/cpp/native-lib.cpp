#include <jni.h>
#include <string>
#include <opencv2/opencv.hpp>

using namespace cv;

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_useopencvwithcmake_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT void JNICALL
Java_com_example_useopencvwithcmake_MainActivity_ConvertRGBtoGray(JNIEnv *env,
                                                                            jobject thiz,
                                                                            jlong mat_addr_input,
                                                                            jlong mat_addr_result) {
    // TODO: implement ConvertRGBtoGray()
    Mat &matInput = *(Mat *)mat_addr_input;
    Mat &matResult = *(Mat *)mat_addr_result;

    cvtColor(matInput, matResult, COLOR_RGBA2GRAY);
    blur( matResult, matResult, Size(5,5));
    Canny( matResult, matResult, 50, 150);
}