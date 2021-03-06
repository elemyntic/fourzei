package com.fourzei;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Utils {
    public static String getData(Context ctx, String field) {
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("com.fourzei", Context.MODE_PRIVATE);
            return prefs.getString("com.fourzei." + field.toLowerCase(), null);
        } catch (Exception e) {
            return null;
        }
    }

    public static void setData(Context ctx, String field, String value) {
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("com.fourzei", Context.MODE_PRIVATE);
            prefs.edit().putString("com.fourzei." + field.toLowerCase(), value).commit();
        } catch (Exception e) {
            Log.d("FOURZEI PREFS", "Error setting pref: " + e.getMessage());
        }
    }

    public static float getDataFlt(Context ctx, String field) {
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("com.fourzei", Context.MODE_PRIVATE);
            return prefs.getFloat("com.fourzei." + field.toLowerCase(), -1);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void setDataFlt(Context ctx, String field, float value) {
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("com.fourzei", Context.MODE_PRIVATE);
            prefs.edit().putFloat("com.fourzei." + field.toLowerCase(), value).commit();
        } catch (Exception e) {
            Log.d("FOURZEI PREFS", "Error setting pref: " + e.getMessage());
        }
    }

    public static long getDataLong(Context ctx, String field) {
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("com.fourzei", Context.MODE_PRIVATE);
            return prefs.getLong("com.fourzei." + field.toLowerCase(), -1);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void setDataLong(Context ctx, String field, long value) {
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("com.fourzei", Context.MODE_PRIVATE);
            prefs.edit().putLong("com.fourzei." + field.toLowerCase(), value).commit();
        } catch (Exception e) {
            Log.d("FOURZEI PREFS", "Error setting pref: " + e.getMessage());
        }
    }

    public static long getLastRequest(Context ctx) {
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("com.fourzei", Context.MODE_PRIVATE);
            return prefs.getLong("com.fourzei.lastrequest", -1);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void setLastRequest(Context ctx, long value) {
        try {
            SharedPreferences prefs = ctx.getSharedPreferences("com.fourzei", Context.MODE_PRIVATE);
            prefs.edit().putLong("com.fourzei.lastrequest", value).commit();
        } catch (Exception e) {
            Log.d("FOURZEI PREFS", "Error setting pref: " + e.getMessage());
        }
    }

    public static int getRandomIndex(int length) {
        return Math.min((int) Math.round(Math.random() * length), length - 1);
    }

    public static int getRandomIndex(int length, int excludeIndex, int tries) {
        int index = getRandomIndex(length);
        if (index != excludeIndex) return index;

        if (tries > 0) {
            return getRandomIndex(length, excludeIndex, --tries);
        }

        return -1;
    }
}
