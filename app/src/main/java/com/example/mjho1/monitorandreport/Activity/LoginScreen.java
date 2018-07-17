package com.example.mjho1.monitorandreport.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mjho1.monitorandreport.Class.BlurBuilder;
import com.example.mjho1.monitorandreport.Class.IOServiceHandle;
import com.example.mjho1.monitorandreport.R;

import org.greenrobot.eventbus.EventBus;

public class LoginScreen extends AppCompatActivity {

    // --- Variables are declared here ---
    // -----------------------------------

    public RelativeLayout mContainerView;
    public Button loginBtn;

    // --- Main body here ---
    // ----------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login_screen);
//        EventBus.getDefault().register(this);

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login_screen);

        mContainerView = (RelativeLayout) findViewById(R.id.loginView);
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.forest);
        Bitmap blurredBitmap = BlurBuilder.blur( this, originalBitmap );
        mContainerView.setBackground(new BitmapDrawable(getResources(), blurredBitmap));

        loginBtn=(Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendLoginInfo();
            }
        });
    }

    // --- Custom functions are declared here ---
    // ------------------------------------------

    private void sendLoginInfo(){
    }
}
