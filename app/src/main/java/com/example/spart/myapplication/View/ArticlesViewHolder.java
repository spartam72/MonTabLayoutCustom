package com.example.spart.myapplication.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.example.spart.myapplication.MyArticleSearchAPI.ArticleSearchArticles;
import com.example.spart.myapplication.R;
import com.example.spart.myapplication.Utils.DateConvertUtils;


import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticlesViewHolder extends  RecyclerView.ViewHolder {

    @BindView(R.id.fragment_recycle_item_image)
    ImageView image;
    @BindView(R.id.fragment_recycle_item_category)
    TextView category;
    @BindView(R.id.fragment_recycle_item_date)
    TextView date;
    @BindView(R.id.fragment_recycle_item_title)
    TextView title;
    @BindView(R.id.fragment_recycle_item_headline)
    TextView headline;




    public ArticlesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithArticleSearch(ArticleSearchArticles articleSearchArticle, RequestManager glide){
        try{
            glide.load("https://static01.nyt.com/" + articleSearchArticle.getMultimedia().get(2).getUrl())
                    .into(image)
                    ;
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        this.category.setText(articleSearchArticle.getSectionName());
        try {
            this.date.setText( DateConvertUtils.getPublished_date_converted( articleSearchArticle.getPubDate().substring(0, 10)));
        }catch (Exception e){

            e.printStackTrace();
        }
        this.title.setText(articleSearchArticle.getSnippet());
        this.headline.setText( articleSearchArticle.getHeadline().getMain() );
    }
}

