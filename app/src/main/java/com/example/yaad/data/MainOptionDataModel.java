package com.example.yaad.data;

import com.example.yaad.R;

import java.util.ArrayList;

public class MainOptionDataModel {
    public static ArrayList<String> getStr(){
        ArrayList<String> arr = new ArrayList<>();
        arr.add("نوی");
        arr.add("تکرار");
        arr.add("ازموینی");
        arr.add("نښانونه");
        arr.add("اهداف");
        arr.add("کاریال په اړه");
        return arr;
    }

    public static ArrayList<Integer> getSrcs(){
        ArrayList<Integer> srcs = new ArrayList<>();
        srcs.add(R.drawable.default_avatar);
        srcs.add(R.drawable.pic3);
        srcs.add(R.drawable.default_avatar);
        srcs.add(R.drawable.default_avatar);
        srcs.add(R.drawable.default_avatar);
        srcs.add(R.drawable.default_avatar);
        return srcs;
    }
}
