package com.easyjobs.mahesh.easyjobs.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.easyjobs.mahesh.easyjobs.JobsData;
import com.easyjobs.mahesh.easyjobs.R;
import com.easyjobs.mahesh.easyjobs.activites.ShowJobData;

import java.util.List;

public class AllJobsShowAdapter extends RecyclerView.Adapter<AllJobsShowAdapter.MyViewHolder> {

    Context context;
    List<JobsData> jobsDataList;

    public AllJobsShowAdapter(Context context, List<JobsData> jobsDataList) {
        this.context = context;
        this.jobsDataList = jobsDataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(context).inflate(R.layout.rowlayout, parent, false);

        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        System.out.println("showData position " + position);
        JobsData jobsData = jobsDataList.get(position);
        System.out.println("showData title " + jobsData.getJobTitle());
        System.out.println("showData desc " + jobsData.getJobDescription());
        System.out.println("showData created at " + jobsData.getCreatedAt());


        holder.jobName.setText(jobsData.getJobTitle());
        holder.jobDesc.setText(jobsData.getJobDescription());
        holder.jobDate.setText(jobsData.getCreatedAt());

        holder.main_row_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                JobsData getData = jobsDataList.get(position);
                Intent intent = new Intent(context, ShowJobData.class);
                intent.putExtra("jobData", getData);
                context.startActivity(intent);

                Toast.makeText(context, "clicked " + getData.getJobTitle(), Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public int getItemCount() {
        System.out.println("showData list size " + jobsDataList.size());
        return jobsDataList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView jobName, jobDate, jobDesc;
        LinearLayout main_row_layout;

        public MyViewHolder(View itemView) {
            super(itemView);

            jobName = (TextView) itemView.findViewById(R.id.jobname);
            jobDate = (TextView) itemView.findViewById(R.id.jobdate);
            jobDesc = (TextView) itemView.findViewById(R.id.jobdesc);
            main_row_layout = (LinearLayout) itemView.findViewById(R.id.main_row_layout);

        }
    }
}
