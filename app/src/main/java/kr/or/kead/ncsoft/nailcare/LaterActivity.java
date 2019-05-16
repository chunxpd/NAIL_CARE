package kr.or.kead.ncsoft.nailcare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LaterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_later);
    }

    public void onClick(View view) {
        finish();
    }
}
