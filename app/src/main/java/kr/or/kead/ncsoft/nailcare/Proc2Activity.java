package kr.or.kead.ncsoft.nailcare;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Proc2Activity extends AppCompatActivity {

    String data="";
    CountDownTimer countDownTimer=null;
    Button button=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proc2);

        Intent intent = getIntent();
        data = intent.getStringExtra("care");

        button = (Button)findViewById(R.id.button_next);
        button.setText(data+ " 진행");
        startTimer();
    }

    protected   void  startTimer() {
        int remainMin = 0;
        switch (data){
            case "기본 케어":
                remainMin=20;
                break;
            case "네일 컬러":
                remainMin=25;
                break;
            case "젤 네일":
                remainMin=25;
                break;
        }
        if(countDownTimer == null) {
            countDownTimer = new CountDownTimer(remainMin * 60 * 1000, 1000) {
                public void onTick(long m) {
                    button.setText(String.format("남은시간 : 00 : %02d : %02d" , m / 60000 , m % 60000 / 1000));
                }

                public void onFinish() {
                    button.setText("시간종료");
                }
            };
        }
        countDownTimer.start();
    }

    protected   void cancelTimer(){
        if(countDownTimer !=null)
            countDownTimer.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cancelTimer();
    }

    public void onClickHome(View view) {
        setResult(2);
        finish();
        //Toast.makeText(this,this.getParent().getLocalClassName(),Toast.LENGTH_SHORT).show();
    }

    public void onClickPrev(View view) {
        finish();
    }
}
