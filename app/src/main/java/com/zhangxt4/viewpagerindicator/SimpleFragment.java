package com.zhangxt4.viewpagerindicator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zhangxt4 on 2016/3/18.
 */
public class SimpleFragment extends Fragment {

    private String mTitle;
    private static final String BUNDLE_KEY = "title";

    public static SimpleFragment newInstance(String title){
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY, title);
        SimpleFragment fragment = new SimpleFragment();
        fragment.setArguments(bundle);

        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null){
            mTitle = bundle.getString(BUNDLE_KEY);
        }
//        TextView textView = new TextView(getActivity());
//        textView.setText(mTitle);
//        textView.setGravity(Gravity.CENTER);
//        return textView;
        View simpleView = inflater.inflate(R.layout.simpletablayout, container, false);
        ((TextView)simpleView.findViewById(R.id.id_textview)).setText(mTitle);
        return simpleView;
    }
}
