package com.softdesign.school.utils;

import android.util.Log;

/**
 * @author Roman Akimenko on 19.01.2016.
 * создаём свой логгер!
 */

public class Lg {  //класс логгер

    private static final String PREFIX = "HTC ";   //приставка к имени - HTC
    public static final int LOGCAT_BUFFER_SIZE = 3000;   //максимальная длина буфера - 3000 байт

    private static boolean shouldLog() {
        return false;  //методу shouldLog возвращаем значение ложь
    }

    /**
     *  метод логирования записей
     * @param tag
     * @param text
     * 1111
     */
    public static void i (String tag, String text){
        if (shouldLog()) {  //если ложь
            if (text.length() > LOGCAT_BUFFER_SIZE){   //если длина текста больше фиксированного значеня, то
                String s = text;   //в перемнную S записываем некий текст
                while (s.length() > LOGCAT_BUFFER_SIZE){  //и пока длина текста больше 3000 мы делаем следующие действия
                    String s1 = s.substring(0, LOGCAT_BUFFER_SIZE);  //в переменную s1 записываем то, что "не вышло за пределы S LOGCAT_BUFFER_SIZE"
                    s = s.substring(LOGCAT_BUFFER_SIZE);  //а в переменную s записываем далее то, что "вышло за пределы S"
                    Log.i(PREFIX + tag, s1);  // далее логируем: приставка + ярлык + основной логируемсый текст
                }
                Log.i(PREFIX + tag, s);  // а затем, что вышло за пределы
            } else {
                Log.i(PREFIX + tag, text);  // если превышения длины текста установленного значения не было, то логируем некий основной текст
            }
        }
    }  //конец метода i

    public static void e (String tag, String text) {
        if (shouldLog()) {
            if (text.length() > LOGCAT_BUFFER_SIZE){
                String s = text;
                while (s.length() > LOGCAT_BUFFER_SIZE){
                    String s1 = s.substring(0, LOGCAT_BUFFER_SIZE);
                    s = s.substring(LOGCAT_BUFFER_SIZE);
                    Log.e(PREFIX + tag, s1);
                }
                Log.e(PREFIX + tag, s);
            } else {
                Log.e(PREFIX + tag, text);
            }
        }
    }

    public static void w (String tag, String text) {
        if (!shouldLog()) {
            if (text.length() > LOGCAT_BUFFER_SIZE){
                String s = text;
                while (s.length() > LOGCAT_BUFFER_SIZE){
                    String s1 = s.substring(0, LOGCAT_BUFFER_SIZE);
                    s = s.substring(LOGCAT_BUFFER_SIZE);
                    Log.w(PREFIX + tag, s1);
                }
                Log.w(PREFIX + tag, s);
            } else {
                Log.w(PREFIX + tag, text);
            }
        }
    }

}
