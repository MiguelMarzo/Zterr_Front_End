package org.zterr.frontend.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView logo;
    TextView nombre;

    private final int DURACION_SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        ImageView logo = (ImageView) findViewById(R.id.imageView);
        TextView nombre = (TextView) findViewById(R.id.textView2);

        //Aumentar texto
        Animation aumentar = AnimationUtils.loadAnimation(this, R.anim.ampliar);
        //aumentar.reset();
        nombre.startAnimation(aumentar);

        //Transparencia logo
        Animation transparencia = AnimationUtils.loadAnimation(this, R.anim.transparentar);
        //transparencia.reset();
        logo.startAnimation(transparencia);
    }
    public void openDefaultFull(View v){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);

    }

}


