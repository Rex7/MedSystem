package com.example.regis.medsystem.research;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.regis.medsystem.R;

import java.util.List;


public class ResearchAdapter extends RecyclerView.Adapter<ResearchAdapter.ViewHolderArticle> {
    private Context context;
    private List<ArticleClass> articleClassList;

    public ResearchAdapter(Context context, List<ArticleClass> articleClassList) {
        this.context = context;
        this.articleClassList = articleClassList;
    }

    @Override
    public ViewHolderArticle onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_layout, parent, false);
        return new ViewHolderArticle(context, v);
    }

    @Override
    public void onBindViewHolder(ViewHolderArticle holder, int position) {
        Log.v("string title", articleClassList.get(position).getAuthorName());
        holder.aricleTitle.setText(articleClassList.get(position).getTitle());
        holder.articleAuthorName.setText(articleClassList.get(position).getAuthorName());
    }

    @Override
    public int getItemCount() {
        Log.v("count ", "No of data " + articleClassList.size());
        return articleClassList.size();

    }

    class ViewHolderArticle extends RecyclerView.ViewHolder {
        TextView aricleTitle, articleAuthorName;

        ViewHolderArticle(Context context, View itemView) {
            super(itemView);
            aricleTitle = (TextView) itemView.findViewById(R.id.titletextArticle);
            articleAuthorName = (TextView) itemView.findViewById(R.id.authorTextArticle);

        }
    }
}