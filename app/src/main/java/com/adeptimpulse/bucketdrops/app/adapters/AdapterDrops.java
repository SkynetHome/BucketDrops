package com.adeptimpulse.bucketdrops.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.adeptimpulse.bucketdrops.app.R;
import com.adeptimpulse.bucketdrops.app.beans.Drop;
import io.realm.RealmResults;

/**
 * Created by Michael Van Dusen on 4/12/2016.
 */
public class AdapterDrops extends RecyclerView.Adapter<AdapterDrops.DropHolder> {

    private LayoutInflater mInflater;
    private RealmResults<Drop> mResults;


    public AdapterDrops(Context context, RealmResults<Drop> results) {
        mInflater = LayoutInflater.from(context);
        update(results);
    }

    public void update(RealmResults<Drop> results) {
        mResults = results;
        notifyDataSetChanged();
    }

    @Override
    public DropHolder onCreateViewHolder(ViewGroup parent, int position) {
         View view = mInflater.inflate(R.layout.row_drop, parent, false );
        DropHolder holder = new DropHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(DropHolder dropHolder, int position) {
        Drop drop = mResults.get(position);
        dropHolder.mTextWhat.setText(drop.getWhat());
    }

    @Override
    public int getItemCount() {
        return mResults.size();
    }

    public static class DropHolder extends RecyclerView.ViewHolder {

        TextView mTextWhat;

        public DropHolder(View itemView) {
            super(itemView);
            mTextWhat = (TextView) itemView.findViewById(R.id.tv_what);
        }
    }
}
