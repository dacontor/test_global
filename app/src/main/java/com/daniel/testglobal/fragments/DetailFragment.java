package com.daniel.testglobal.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.daniel.testglobal.R;
import com.daniel.testglobal.core.models.HomeObject;
import com.daniel.testglobal.utils.UserUtils;

import java.util.Objects;

public class DetailFragment extends Fragment {

    private HomeObject mObject;

    //private TextView title;
    private TextView description;
    private ImageView image;
    private FrameLayout frameLayout;

    public static DetailFragment newInstance(HomeObject data) {
        DetailFragment fragment = new DetailFragment();
        Bundle b = new Bundle();
        b.putParcelable("data", data);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle b = getArguments();

        assert b != null;
        mObject = b.getParcelable("data");
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        frameLayout = new FrameLayout(Objects.requireNonNull(getActivity()));
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        //title = view.findViewById(R.id.title);
        description = view.findViewById(R.id.description);
        image = view.findViewById(R.id.image);

        frameLayout.addView(view);
        return frameLayout;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadConfig();

    }

    private void loadConfig() {

        //title.setText(mObject.getTitle());
        description.setMovementMethod(new ScrollingMovementMethod());
        description.setText(mObject.getDescription());
        UserUtils.loadImage(image, mObject.getImage(), getActivity());

    }

    @SuppressLint("InflateParams")
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        frameLayout.removeAllViews();

        LayoutInflater inflater = (LayoutInflater) Objects.requireNonNull(getActivity()).getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View view = inflater.inflate(R.layout.fragment_detail, null);

        description = view.findViewById(R.id.description);
        image = view.findViewById(R.id.image);

        frameLayout.addView(view);
        loadConfig();
    }
}
