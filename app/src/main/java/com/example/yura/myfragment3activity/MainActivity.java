package com.example.yura.myfragment3activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FrameLayout container;
    FragmentManager myFragmentManager;
    MyFragment1 myFragment1;
    MyFragment2 myFragment2;
    MyFragment3 myFragment3;
    final static String TAG_1 = "FRAGMENT_1";
    final static String TAG_2 = "FRAGMENT_2";
    final static String TAG_3 = "FRAGMENT_3";
    final static String KEY_MSG_1 = "FRAGMENT1_MSG";
    final static String KEY_MSG_2 = "FRAGMENT2_MSG";
    final static String KEY_MSG_3 = "FRAGMENT3_MSG";

    // класс для первого фрагмента
    public static class MyFragment1 extends Fragment {

        TextView textMsg;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment1, null);
            textMsg = (TextView) view.findViewById(R.id.tvMessage);

            Bundle bundle = getArguments();
            if (bundle != null) {
                String msg = bundle.getString(KEY_MSG_1);
                if (msg != null) {
                    textMsg.setText(msg);
                }
            }
            return view;
        }

        public void setMsg(String msg) {
            textMsg.setText(msg);
        }
    }

    // класс для второго фрагмента
    public static class MyFragment2 extends Fragment {

        TextView textMsg;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment2, null);
            textMsg = (TextView) view.findViewById(R.id.tvMessage);

            Bundle bundle = getArguments();
            if (bundle != null) {
                String msg = bundle.getString(KEY_MSG_2);
                if (msg != null) {
                    textMsg.setText(msg);
                }
            }
            return view;
        }

        public void setMsg(String msg) {
            textMsg.setText(msg);
        }
    }

    // класс для третьего фрагмента
    public static class MyFragment3 extends Fragment {

        TextView textMsg;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment3, null);
            textMsg = (TextView) view.findViewById(R.id.tvMessage);

            Bundle bundle = getArguments();
            if (bundle != null) {
                String msg = bundle.getString(KEY_MSG_3);
                if (msg != null) {
                    textMsg.setText(msg);
                }
            }
            return view;
        }

        public void setMsg(String msg) {
            textMsg.setText(msg);
        }
    }

    // метод основной активности
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        container = (FrameLayout) findViewById(R.id.container);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        myFragmentManager = getSupportFragmentManager();


        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                MyFragment1 fragment = (MyFragment1) myFragmentManager
                        .findFragmentByTag(TAG_1);

                if (fragment == null) {

                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_MSG_1, "Заменили на первый фрагмент");
                    myFragment1.setArguments(bundle);

                    FragmentTransaction fragmentTransaction = myFragmentManager
                            .beginTransaction();
                    fragmentTransaction.replace(R.id.container, myFragment1,
                            TAG_1);
                    fragmentTransaction.commit();

                } else {
                    fragment.setMsg("Первый фрагмент уже загружен");
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                MyFragment2 fragment = (MyFragment2) myFragmentManager
                        .findFragmentByTag(TAG_2);

                if (fragment == null) {

                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_MSG_2, "Заменили на второй фрагмент");
                    myFragment2.setArguments(bundle);

                    FragmentTransaction fragmentTransaction = myFragmentManager
                            .beginTransaction();
                    fragmentTransaction.replace(R.id.container, myFragment2,
                            TAG_2);
                    fragmentTransaction.commit();

                } else {
                    fragment.setMsg("Второй фрагмент уже загружен");
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                MyFragment3 fragment = (MyFragment3) myFragmentManager
                        .findFragmentByTag(TAG_3);

                if (fragment == null) {

                    Bundle bundle = new Bundle();
                    bundle.putString(KEY_MSG_3, "Заменили на третий фрагмент");
                    myFragment3.setArguments(bundle);

                    FragmentTransaction fragmentTransaction = myFragmentManager
                            .beginTransaction();
                    fragmentTransaction.replace(R.id.container, myFragment3,
                            TAG_3);
                    fragmentTransaction.commit();

                } else {
                    fragment.setMsg("Третий фрагмент уже загружен");
                }
            }
        }
        );


        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();


        if (savedInstanceState == null) {
            // при первом запуске программы
            FragmentTransaction fragmentTransaction = myFragmentManager
                    .beginTransaction();
            // добавляем в контейнер при помощи метода add()
            fragmentTransaction.add(R.id.container, myFragment1, TAG_1);
            fragmentTransaction.commit();
        }
    }
}


