package com.clipandbooks.sample.listsamples;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by checks on 2016-01-22.
 */
public class MainActivity1 extends Activity  implements AdapterView.OnItemClickListener{

    private ListView mListView = null;
    private ListViewAdapter mAdapter = null;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("TAG", "position:" + position);
    }

    private class ViewHolder {
        public TextView mTitle;
        public TextView mSubscribe;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.list);

        mAdapter = new ListViewAdapter(this);
        mAdapter.addItem("TST", "TTT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");
        mAdapter.addItem("TTT", "TT");

        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    public class ListViewAdapter extends BaseAdapter {

        private Context mContext;
        private ArrayList<ListData> mListData = new ArrayList<>();

        public ListViewAdapter(Context context) {
            super();
            mContext = context;
        }

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();

                LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.list_custom_item, null);

                holder.mTitle = (TextView)convertView.findViewById(R.id.item_title);
                holder.mSubscribe = (TextView)convertView.findViewById(R.id.item_subscribe);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder)convertView.getTag();
            }

            ListData mData = mListData.get(position);

            holder.mTitle.setText(mData.mTitle);
            holder.mSubscribe.setText(mData.mSubscribe);

            return convertView;
        }

        public void addItem(String title, String subscribe) {
            ListData listItem = new ListData();
            listItem.mTitle = title;
            listItem.mSubscribe = subscribe;

            mListData.add(listItem);
        }

        public void dataChange() {
            mAdapter.notifyDataSetChanged();
        }


    }


}
