package kr.or.kead.ncsoft.nailcare;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Step1Activity extends AppCompatActivity {

    String data="";
    String shape="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step1);

        Intent intent = getIntent();
        data = intent.getStringExtra("care");
    }

    public void onClick(View view) {
        //Toast.makeText(this, ((String) view.getId()),Toast.LENGTH_SHORT).show();
        ImageView imageView1 = (ImageView)findViewById(R.id.round);
        ImageView imageView2 = (ImageView)findViewById(R.id.oval);
        ImageView imageView3 = (ImageView)findViewById(R.id.square);
        //imageView1.setColorFilter(0xff878787, PorterDuff.Mode.MULTIPLY);
        switch (view.getId()) {
            case R.id.round:
                shape="round";
                imageView1.setColorFilter(0xff878787, PorterDuff.Mode.MULTIPLY);
                imageView2.clearColorFilter();
                imageView3.clearColorFilter();
                break;
            case R.id.oval:
                shape="oval";
                imageView1.clearColorFilter();
                imageView2.setColorFilter(0xff878787, PorterDuff.Mode.MULTIPLY);
                imageView3.clearColorFilter();
                break;
            case R.id.square:
                shape="square";
                imageView1.clearColorFilter();
                imageView2.clearColorFilter();
                imageView3.setColorFilter(0xff878787, PorterDuff.Mode.MULTIPLY);
                break;
        }
        //Toast.makeText(this, String.format("%d",shape), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this,Step4Activity.class);
        intent.putExtra("care",data);
        intent.putExtra("shape",shape);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==2) {
            setResult(2);
            finish();
        }
    }

}
