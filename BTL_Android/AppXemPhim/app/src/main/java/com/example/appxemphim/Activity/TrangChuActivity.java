package com.example.appxemphim.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.appxemphim.Adapter.SliderAdapter;
import com.example.appxemphim.Domain.Slider;
import com.example.appxemphim.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class TrangChuActivity extends AppCompatActivity {
    private ArrayList<Slider> lstDeXuat, lstPhimBo, lstPhimLe, lstHoatHinh;
    private SliderAdapter adapterDeXuat, adapterPhimbo, adapterPhimle, adapterHoathinh;
    private ViewPager vpslider;
    private EditText etSearch;
    private CircleIndicator indicator;
    private ImageButton btnPlay;
    private int currentPage = 0;
    final long DELAY_MS = 1000; // Độ trễ giữa các cuộn
    final long PERIOD_MS = 3000; // Thời gian giữa các cuộn
    private Timer timer;
    private TabLayout tbMenu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        findID();

        // Đề xuất
        sliderDeXuat();

        // Menu
        LoadMenu();

        // chạy slider
        runSlider();
    }

    // Tìm id
    public void findID(){
        vpslider = findViewById(R.id.vpSlider);
        etSearch = findViewById(R.id.etTimKiem);
        btnPlay = findViewById(R.id.btnPlay);
        indicator = findViewById(R.id.indicator);
        tbMenu = findViewById(R.id.tbMenu);
    }

    // Menu
    public void LoadMenu(){
        tbMenu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 1:
                        sliderPhimBo();
                        return;
                    case 2:
                        sliderPhimLe();
                        return;
                    case 3:
                        sliderHoatHinh();
                        return;
                    default:
                        sliderDeXuat();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    // Slider Đề xuất
    public void sliderDeXuat(){
        lstDeXuat = new ArrayList<>();

        lstDeXuat.add(new Slider(R.drawable.anh3, "Liên hoa lâu|Trung Quốc đại lục|Trọn bộ 40 tập"));
        lstDeXuat.add(new Slider(R.drawable.anh4, "Trường nguyệt tẫn minh|Trung Quốc..|Trọn bộ 40 tập"));
        lstDeXuat.add(new Slider(R.drawable.anh19, "The Call|Hàn Quốc"));
        lstDeXuat.add(new Slider(R.drawable.anh22, "OnePice|Nhật Bản|..."));
        lstDeXuat.add(new Slider(R.drawable.anh15, "Liên hoa lâu|Trung Quốc đại lục|..."));
        lstDeXuat.add(new Slider(R.drawable.anh13, "Avartar|Hoa Kỳ"));

        adapterDeXuat = new SliderAdapter(this, lstDeXuat);
        vpslider.setAdapter(adapterDeXuat);
        indicator.setViewPager(vpslider);
        adapterDeXuat.registerDataSetObserver(indicator.getDataSetObserver());
    }

    // Slider Phim Bộ
    public void sliderPhimBo(){
        lstPhimBo = new ArrayList<>();

        lstPhimBo.add(new Slider(R.drawable.anh20, "Goblin|Hàn Quốc|Trọn bộ 16 tập"));
        lstPhimBo.add(new Slider(R.drawable.anh9, "Trường Phong Độ|Trung Quốc..|Trọn bộ 40 tập"));
        lstPhimBo.add(new Slider(R.drawable.anh15, "The W|Hàn Quốc|Trọn bộ 16 tập"));

        adapterPhimbo = new SliderAdapter(this, lstPhimBo);
        vpslider.setAdapter(adapterPhimbo);
        indicator.setViewPager(vpslider);
        adapterPhimbo.registerDataSetObserver(indicator.getDataSetObserver());
    }

    // Slider Phim Bộ
    public void sliderPhimLe(){
        lstPhimLe = new ArrayList<>();

        lstPhimLe.add(new Slider(R.drawable.anh19, "The Call | Hàn Quốc"));
        lstPhimLe.add(new Slider(R.drawable.anh13, "Avartar | Hoa Kỳ"));

        adapterPhimle = new SliderAdapter(this, lstPhimLe);
        vpslider.setAdapter(adapterPhimle);
        indicator.setViewPager(vpslider);
        adapterPhimle.registerDataSetObserver(indicator.getDataSetObserver());
    }

    // Slider Hoạt hình
    public void sliderHoatHinh(){
        lstHoatHinh = new ArrayList<>();

        lstHoatHinh.add(new Slider(R.drawable.anh22, "OnePice|Nhật Bản|..."));
        lstHoatHinh.add(new Slider(R.drawable.anh21, "Thiếu niên ca hành|Trung Quốc đại lục|..."));
        lstHoatHinh.add(new Slider(R.drawable.anh21, "Thiếu niên ca hành|Trung Quốc đại lục|..."));

        adapterHoathinh = new SliderAdapter(this, lstHoatHinh);
        vpslider.setAdapter(adapterHoathinh);
        indicator.setViewPager(vpslider);
        adapterHoathinh.registerDataSetObserver(indicator.getDataSetObserver());
    }

    // Cuộn slider
    public void runSlider(){
        timer = new Timer();
        // Tạo một TimerTask để cuộn ViewPager
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Kiểm tra nếu currentPage là trang cuối cùng
                if (currentPage == vpslider.getAdapter().getCount() - 1) {
                    // Quay lại trang đầu tiên
                    currentPage = 0;
                } else {
                    // Di chuyển đến trang tiếp theo
                    currentPage++;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        vpslider.setCurrentItem(currentPage, true);
                    }
                });
            }
        }, DELAY_MS, PERIOD_MS);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Hủy Timer khi hoạt động bị hủy
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
   }
}