package example.itsme.collections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    protected List<course> data;
    public static final String Course_Num = "CourseNumber";
    public static final String Course_Cridet = "CourseCridet";
    public static final String Course_Title = "CourseTitle";
    public static final String Course_Desc = "CourseDesc";
    public static final int Detail_request_code = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = Data_Provider.getData();
        ArrayAdapter<course> courseArrayAdapter = new CourseArrayAdapter(this, 0, data);

        ListView lv = (ListView) findViewById(R.id.list);
        lv.setAdapter(courseArrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                course course = data.get(i);
                String img[] = {"image_1001", "image_1002", "image_1003", "image_1004", "image_1005"};
                String imgId = img[i];
                DisplayDetail(course, imgId);

            }

            private void DisplayDetail(course course, String imgId) {

                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("Course_Title", course.getTitle());
                intent.putExtra("Course_Desc", course.getDescription());
                intent.putExtra("Course_Num", course.getCourse_Num());
                intent.putExtra("Course_Cridet", course.getCridet());
                intent.putExtra("imgId", imgId);
                startActivityForResult(intent, Detail_request_code);


            }

            public void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (requestCode == Detail_request_code) {
                    if (resultCode == RESULT_OK) {

                        String msg = data.getStringExtra("resultMessage");
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                }


            }
        });


    }

    class CourseArrayAdapter extends ArrayAdapter<course> {
        Context context;
        List<course> objects;


        public CourseArrayAdapter(Context context, int resource, List<course> objects) {
            super(context, resource, objects);
            this.context = context;
            this.objects = objects;


        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            course course = objects.get(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.course_item, null);

//            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//            View view= inflater.inflate(R.layout.course_item,null);
            TextView tv = (TextView) view.findViewById(R.id.tvTitle);
            tv.setText(course.getTitle());
            ImageView iv = (ImageView) view.findViewById(R.id.imageCourse);
            int res = context.getResources().getIdentifier("image_" + course.getCourse_Num(), "drawable",
                    context.getPackageName()

            );
            iv.setImageResource(res);


            return view;
        }
    }
}

