package com.example.tugasbesar_03.view;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasbesar_03.R;
import com.example.tugasbesar_03.adapter.Adapter_Page;
import com.example.tugasbesar_03.view.pinchToZoom.ImageZoom;
import com.example.tugasbesar_03.view.pinchToZoom.PageZoomOut;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MangaReader extends FragmentActivity {
    private String BASE_URL = "https://www.mangaeden.com/api/chapter/";
    protected ImageZoom imageZoom;
    protected RecyclerView pageList;
    protected Adapter_Page pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_reader);

        // findViewById()
        pageList = findViewById(R.id.amr_rv_pageList);
        imageZoom = findViewById(R.id.amr_vp_imageZoom);

        // setPageTransformer buat ViewPager di layout xmlnya
        imageZoom.setPageTransformer(true, new PageZoomOut());

        
    }

    /* method ini buat meng-allow sistem untuk handle "back" button.
     * nanti methodnya manggil method finish() buat activity ini jadi
     * kembali ke view sebelumnya
     */
    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    /* method ini ngatur biar pas user click si gambar manganya, listview page yg bagian bawahnya ilang, jadi kaya fullscreen gitu lah
     */
    
    public void OnClick(boolean var) {
        BottomNavigationView view_bottom = findViewById(R.id.amr_bnv_navigation);
        Animation bottomUp = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.pagelist_up);
        Animation bottomDown= AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.pagelist_down);
        if(view_bottom.getVisibility()== View.VISIBLE){
            //hide it
            view_bottom.startAnimation(bottomDown);
            view_bottom.setVisibility(View.INVISIBLE);
        }else{
            //show it
            view_bottom.startAnimation(bottomUp);
            view_bottom.setVisibility(View.VISIBLE);
        }
    }
}
