package kr.or.kead.ncsoft.nailcare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Button button = (Button) findViewById(R.id.basic_care);
        //button.setText(Html.fromHtml(getString(R.string.basic_care)));
    }

    public void onClickLater(View view) {
        Intent intent = new Intent(this, LaterActivity.class);
        startActivity(intent);
        finish();
    }

    public void onClickBasic(View view) {
        Intent intent = new Intent(this, Proc1Activity.class);
        intent.putExtra("care","기본 케어");
        startActivityForResult(intent,0);
    }

    public void onClickColor(View view) {
        Intent intent = new Intent(this, Proc1Activity.class);
        intent.putExtra("care","네일 컬러");
        startActivityForResult(intent,0);
    }

    public void onClickGel(View view) {
        Intent intent = new Intent(this, Proc1Activity.class);
        intent.putExtra("care","젤 네일");
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==2) {
            setResult(2);
            finish();
        }
    }
}
