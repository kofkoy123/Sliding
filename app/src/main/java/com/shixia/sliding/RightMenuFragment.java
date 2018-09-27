package com.shixia.sliding;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/9/27.
 */

public class RightMenuFragment extends Fragment {

    private RecyclerView mNewsList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        mNewsList = view.findViewById(R.id.news_list);
        setAdapter();
        return view;
    }

    private void setAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        mNewsList.setLayoutManager(manager);

        final List<String> titleList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            titleList.add("这是标题" + i);
        }
        NewsAdapter adapter = new NewsAdapter(getActivity(), titleList);
        mNewsList.setAdapter(adapter);
        adapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), titleList.get(position), Toast.LENGTH_LONG).show();
            }
        });
    }
}
