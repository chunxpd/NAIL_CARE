package kr.or.kead.ncsoft.nailcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Step5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step5);
    }

    public void onClickHome(View view) {
        setResult(2);
        finish();
    }

    public void onClickPrev(View view) {
        finish();
    }
}
