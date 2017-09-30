package guru.nickthompson.livethread;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import guru.nickthompson.redditapi.Comment;

/**
 * Created by williamreed on 9/29/17.
 * <p>
 * Adapter for intermediary between data and recycler view
 * thanks code path
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvUsername;
        public TextView tvDate;
        public TextView tvContent;

        public ViewHolder(View itemView) {
            super(itemView);

            tvUsername = (TextView) itemView.findViewById(R.id.tv_post_username);
            tvDate = (TextView) itemView.findViewById(R.id.tv_post_date);
            tvContent = (TextView) itemView.findViewById(R.id.tv_post_content);
        }
    }

    private List<Comment> comments;
    private Context context;

    public CommentsAdapter(Context context, List<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    private Context getContext() {
        return context;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_post_comment, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(CommentsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Comment comment = comments.get(position);

        // Set item views based on your views and data model
        TextView username = viewHolder.tvUsername;
        username.setText(comment.getUsername());

        TextView date = viewHolder.tvDate;
        date.setText(comment.getTimeStamp().toString());

        TextView content = viewHolder.tvContent;
        // deprectated but we cant use newer version bc it requries >API 24
        content.setText(Html.fromHtml(comment.getBody()));
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return comments.size();
    }
}