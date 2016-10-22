package example.itsme.collections;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;

public class DetailActivity extends AppCompatActivity {


    public String CourseTitle;
    public String CourseDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        CourseTitle = getIntent().getStringExtra("Course_Title");
        TextView tvtitle = (TextView) findViewById(R.id.tvTitle);
        tvtitle.setText(CourseTitle);
        Log.d("Result:",CourseTitle);

        CourseDesc = getIntent().getStringExtra("Course_Desc");
        TextView tvDesc = (TextView) findViewById(R.id.course_desc);
        tvDesc.setText(CourseDesc);


        int CourseNum = getIntent().getIntExtra("Course_Num",0);
        Log.d("Result: ",CourseNum+"");
        TextView tv_course = (TextView) findViewById(R.id.course_Number);
        tv_course.setText("Course :" + CourseNum);


        double CourseCridet = getIntent().getDoubleExtra("Course_Cridet", 0);
        TextView tv_cridet = (TextView) findViewById(R.id.Course_Cridet);
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumFractionDigits(1);
        tv_cridet.setText("CourseCridets :" + formatter.format(CourseCridet));

        ImageView iv = (ImageView) findViewById(R.id.img_desc);
        String imgId=getIntent().getStringExtra("imgId");
        int res = getResources().getIdentifier(imgId, "drawable", getPackageName());
        iv.setImageResource(res);
    }

    public void registerClickHandler(View view) {
        getIntent().putExtra("result Message", "You are Registered for " + CourseTitle);
        setResult(RESULT_OK, getIntent());
        finish();


    }

}

