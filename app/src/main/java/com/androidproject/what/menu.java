package com.androidproject.what;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

/**
 * Created by Firat on 29.1.2015.
 */
public class menu extends ActionBarActivity {
    Helper helper;
    MediaPlayer buttonClick_sound;
    Animation animTranslate;
    Animation animAlpha;
    Animation animScale;
    Animation animRotate;
    Animation animRotateRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        helper = Helper.INSTANCE;
        helper.tamEkran(this);
        buttonClick_sound = MediaPlayer.create(menu.this, R.raw.button_click);

        animTranslate = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        animScale = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
        animRotate = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        animRotateRefresh = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
        animRotateRefresh.setRepeatMode(0);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.itemMenu_Ara:
                helper.gosterBilgiMesaji(this, "Ara");
                break;
            case R.id.itemMenu_Cikis:
                helper.cikis(this);
                break;
          /*  case R.id.action_settings:
                helper.gosterBilgiMesaji(this, "Ayarlar");
                break;*/
            default:
                helper.gosterBilgiMesaji(this, "Anlamsız");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    public void btnSettingOnClick(View v){
        buttonClick_sound.start();
        helper.goster(this, setting.class);
    }
    public void btnRefreshOnClick(View v){
        buttonClick_sound.start();
        v.startAnimation(animRotateRefresh);
    }
    public void btnProfilOnClick(View v) {
        buttonClick_sound.start();
        helper.goster(this, profil.class);
    }
    public void btnNeNeredeOnClick(View v) {
        animTranslate.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim)
            {
            };
            public void onAnimationRepeat(Animation anim)
            {
            };
            public void onAnimationEnd(Animation anim)
            {
                buttonClick_sound.start();
                helper.goster(menu.this, ne_nerede.class);
            };
        });
        v.startAnimation(animTranslate);
    }
    public void btnNeNereyeOnClick(View v) {
        animTranslate.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim)
            {
            };
            public void onAnimationRepeat(Animation anim)
            {
            };
            public void onAnimationEnd(Animation anim)
            {
                buttonClick_sound.start();
                helper.goster(menu.this, ne_nereye.class);
            };
        });
        v.startAnimation(animTranslate);
    }
    public void btnNeNasilOnClick(View v) {
        animTranslate.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim)
            {
            };
            public void onAnimationRepeat(Animation anim)
            {
            };
            public void onAnimationEnd(Animation anim)
            {
                buttonClick_sound.start();
                helper.goster(menu.this, ne_nasil.class);
            };
        });
        v.startAnimation(animTranslate);
    }
    public void btnNeNezamanOnClick(View v) {
        animTranslate.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim)
            {
            };
            public void onAnimationRepeat(Animation anim)
            {
            };
            public void onAnimationEnd(Animation anim)
            {
                buttonClick_sound.start();
                helper.goster(menu.this, ne_nezaman.class);
            };
        });
        v.startAnimation(animTranslate);
    }
    public void btnNeNedirOnClick(View v) {
        animTranslate.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim)
            {
            };
            public void onAnimationRepeat(Animation anim)
            {
            };
            public void onAnimationEnd(Animation anim)
            {
                buttonClick_sound.start();
                helper.goster(menu.this, ne_nedir.class);
            };
        });
        v.startAnimation(animTranslate);
    }
    public void btnNeNeymisOnClick(View v) {
        animTranslate.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim)
            {
            };
            public void onAnimationRepeat(Animation anim)
            {
            };
            public void onAnimationEnd(Animation anim)
            {
                buttonClick_sound.start();
                helper.goster(menu.this, ne_neymis.class);
            };
        });
        v.startAnimation(animTranslate);
    }
    public void btnNeNedemekOnClick(View v) {
        animTranslate.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim)
            {
            };
            public void onAnimationRepeat(Animation anim)
            {
            };
            public void onAnimationEnd(Animation anim)
            {
                buttonClick_sound.start();
                helper.goster(menu.this, ne_nedemek.class);
            };
        });
        v.startAnimation(animTranslate);
    }
    public void btnNeNeredeNekadarOnClick(View v) {
        animTranslate.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim)
            {
            };
            public void onAnimationRepeat(Animation anim)
            {
            };
            public void onAnimationEnd(Animation anim)
            {
                buttonClick_sound.start();
                helper.goster(menu.this, ne_nerede_nekadar.class);
            };
        });
        v.startAnimation(animTranslate);
    }
    public void btnNeNekadarOnClick(View v) {
        animTranslate.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation anim)
            {
            };
            public void onAnimationRepeat(Animation anim)
            {
            };
            public void onAnimationEnd(Animation anim)
            {
                buttonClick_sound.start();
                helper.goster(menu.this, ne_nekadar.class);
            };
        });
        v.startAnimation(animTranslate);
    }
}
