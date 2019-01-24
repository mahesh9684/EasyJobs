package com.easyjobs.mahesh.easyjobs.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.easyjobs.mahesh.easyjobs.JobsData;
import com.easyjobs.mahesh.easyjobs.R;

import org.w3c.dom.Text;

public class ShowJobData extends AppCompatActivity {

    TextView showName, showDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_job_data);

        showName = (TextView) findViewById(R.id.show_name);
        showDesc = (TextView) findViewById(R.id.show_desc);

        JobsData jobsData = (JobsData) getIntent().getSerializableExtra("jobData");

        showName.setText(jobsData.getJobTitle());
        showDesc.setText(jobsData.getJobDescription());
    }
}
