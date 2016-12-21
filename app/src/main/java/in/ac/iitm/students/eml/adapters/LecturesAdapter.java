package in.ac.iitm.students.eml.adapters;

import android.content.Context;
import android.content.Intent;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.android.Utils;
import com.squareup.picasso.Picasso;

import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import in.ac.iitm.students.eml.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Sathwik on 20-12-2016.
 */
public class LecturesAdapter extends RecyclerView.Adapter<LecturesAdapter.ViewHolder> {
    //
    private Context context;
    private ArrayList<String> lecturers, times;

    public LecturesAdapter(ArrayList<String> lecturers, ArrayList<String> times, Context context) {
        this.lecturers = lecturers;
        this.times = times;
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvLecturer, tvTime;
        RelativeLayout rlLecture;
        ImageView ivLecturePic;

        ViewHolder(View itemView) {
            super(itemView);

            tvLecturer = (TextView) itemView.findViewById(R.id.tv_lecturer);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            rlLecture = (RelativeLayout) itemView.findViewById(R.id.rl_item_lecture);
            ivLecturePic = (ImageView) itemView.findViewById(R.id.iv_item_lecture_pic);
        }


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lecture, parent, false);
        context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LecturesAdapter.ViewHolder holder, final int position) {

        final String title = lecturers.get(position);
        holder.tvLecturer.setText(title);
        holder.tvTime.setText(times.get(position));
        holder.rlLecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked " + title, Toast.LENGTH_SHORT).show();
            }
        });

        int bgColors[] = {R.color.amber, R.color.cyan, R.color.brown, R.color.lightGreen};
        holder.ivLecturePic.setBackgroundResource(bgColors[(position % 4)]);

        String url = "http://res.cloudinary.com/dqmdyvfpp/image/upload/" +
                "h_" + 198 +
                ",c_fill/ChoreoHeader.jpg";
        Toast.makeText(context, url, Toast.LENGTH_SHORT).show();
        Picasso.with(context).load(url).into(holder.ivLecturePic);

    }


    @Override
    public int getItemCount() {
        return lecturers.size();
    }

}
