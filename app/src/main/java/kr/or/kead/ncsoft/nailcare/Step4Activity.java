package kr.or.kead.ncsoft.nailcare;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Step4Activity extends AppCompatActivity {
    String caretype="";
    int f_cot[] = new int[10];
    int f_colour[] = new int[10];
    String shape;
    LinearLayout painLinearLayout;
    CountDownTimer countDownTimer=null;
    Vibrator vib;

    protected   void  startTimer() {
        final TextView rtimeTextView = (TextView)findViewById(R.id.remain_time);
        int remainMin = 20;
        if(countDownTimer == null) {
            countDownTimer = new CountDownTimer((remainMin * 60 + 1) * 1000, 1000) {
                public void onTick(long m) {
                    rtimeTextView.setText(String.format("00 : %02d : %02d" , m / 60000 , m % 60000 / 1000));
                }

                public void onFinish() {
                    rtimeTextView.setText("시간종료");
                }
            };
        }
        countDownTimer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step4);  // 상품주는 버튼 안보이게 바꿈 20190516 chun
        ImageView imageView = (ImageView)findViewById(R.id.btn_end);
        imageView.setVisibility(View.INVISIBLE);
         painLinearLayout = (LinearLayout)findViewById(R.id.pain);

        Intent intent = getIntent();

        shape = intent.getStringExtra("shape");
        caretype = intent.getStringExtra("care");

        vib = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        ImageView imageViewFinger[]={
                (ImageView) findViewById(R.id.finger_0),
                (ImageView) findViewById(R.id.finger_1),
                (ImageView) findViewById(R.id.finger_2),
                (ImageView) findViewById(R.id.finger_3),
                (ImageView) findViewById(R.id.finger_4),
                (ImageView) findViewById(R.id.finger_5),
                (ImageView) findViewById(R.id.finger_6),
                (ImageView) findViewById(R.id.finger_7),
                (ImageView) findViewById(R.id.finger_8),
                (ImageView) findViewById(R.id.finger_9),
        };

        switch(shape) {
            case "round":
                for(int i=0;i<10;i++) {
                    imageViewFinger[i].setBackgroundResource(R.drawable.finger_round);
                }
                break;
            case "oval":
                for(int i=0;i<10;i++) {
                    imageViewFinger[i].setBackgroundResource(R.drawable.finger_oval);
                }
                break;
            case "square":
                for(int i=0;i<10;i++) {
                    imageViewFinger[i].setBackgroundResource(R.drawable.finger_square);
                }
                break;
        }

        startTimer();
    }

    public void onClickPrev(View view) {
        finish();
    }

    public void onClickHome(View view) {
        setResult(2);
        finish();
    }

    public void onClickNext(View view) {
        Intent intent = new Intent(this, Step5Activity.class);
        startActivityForResult(intent, 0);
    }

    public void onClickPain(View view) {
        painLinearLayout.setVisibility(View.VISIBLE);
        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(300);
        anim.setRepeatCount(Animation.INFINITE);
        painLinearLayout.startAnimation(anim);
        long[] pattern = {0,100,100,100,150,100,100,100,150,400,200};
        vib.vibrate(pattern,0);
    }

    public void onClickClose(View view) {
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.preview);
        frameLayout.setVisibility(View.GONE);
        startTimer();
    }

    public void onClickClosePain(View view) {
        //LinearLayout linearLayout = (LinearLayout)findViewById(R.id.pain);
        painLinearLayout.clearAnimation();
        painLinearLayout.setVisibility(View.INVISIBLE);
        vib.cancel();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==2) {
            setResult(2);
            finish();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(vib != null) vib.cancel();
    }
}
