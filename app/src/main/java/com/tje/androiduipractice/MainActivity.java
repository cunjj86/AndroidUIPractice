package com.tje.androiduipractice;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tje.androiduipractice.adapters.PagerAdapter;
import com.tje.androiduipractice.databinding.ActivityMainBinding;
import com.tje.androiduipractice.fragments.FragmentTwo;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;
    PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        act.changeFragOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.viewPager.setCurrentItem(0);

                act.changeFragOneBtn.setText("현재 선택됨");
                act.changeFragTwoBtn.setText("2번 프래그먼트");
                act.changeFragThreeBtn.setText("3번 프래그먼트");
            }
        });

        act.changeFragTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Fragment fr = new FragmentTwo();
//
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragOne, fr);
//                fragmentTransaction.commit();

//                2번 화면 버튼을 누름 => 2번째 페이지를 보여주자.

                act.viewPager.setCurrentItem(1);

                act.changeFragOneBtn.setText("1번 프래그먼트");
                act.changeFragTwoBtn.setText("현재 선택됨");
                act.changeFragThreeBtn.setText("3번 프래그먼트");
            }
        });

        act.changeFragThreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                act.viewPager.setCurrentItem(2);

                act.changeFragOneBtn.setText("1번 프래그먼트");
                act.changeFragTwoBtn.setText("2번 프래그먼트");
                act.changeFragThreeBtn.setText("현재 선택됨");
            }
        });

        act.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                if (i == 0) {
                    act.changeFragOneBtn.setText("현재 선택됨");
                    act.changeFragTwoBtn.setText("2번 프래그먼트");
                    act.changeFragThreeBtn.setText("3번 프래그먼트");
                }
                else if (i == 1) {
                    act.changeFragOneBtn.setText("1번 프래그먼트");
                    act.changeFragTwoBtn.setText("현재 선택됨");
                    act.changeFragThreeBtn.setText("3번 프래그먼트");
                }
                else if (i == 2) {
                    act.changeFragOneBtn.setText("1번 프래그먼트");
                    act.changeFragTwoBtn.setText("2번 프래그먼트");
                    act.changeFragThreeBtn.setText("현재 선택됨");
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

//                버튼이 눌렸을때 하고싶은 일?

//                1. 지금 보여지고 있는 Fragment에 접근
//                 => 현재 작성중인 MainActivity에서?

//                2. 접근한 Fragment 에게 어떻게 작업을 시킬건지?
            }
        });

        act.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public void setValues() {

        act.viewPager.setOffscreenPageLimit(4); // 프래그먼트의 갯수와 맞춰주자!!

        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), 3);
        act.viewPager.setAdapter(pagerAdapter);

    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }
}
