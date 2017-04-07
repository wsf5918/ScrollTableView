package com.loopeer.android.librarys.horizontalverticalscrollview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.loopeer.android.librarys.scrolltable.CustomTableView;
import com.loopeer.android.librarys.scrolltable.ScrollTableView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String[] topTitles = new String[]{"Time", "ins&Outs", "Reason", "OrderNo"};

    private ScrollTableView scrollTableView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollTableView = (ScrollTableView) findViewById(R.id.scroll_table_view);
        ArrayList<String> leftTitle = createLeftTitle();
        ArrayList<String> topTitles = createTopTitles();
        scrollTableView.setDatas(createTopTitles(), createLeftTitle(), createContent(leftTitle.size(), topTitles.size()));
        scrollTableView.hideLeftTitleDisplay();

        scrollTableView.setCellItemCollectSelected(new CustomTableView.IOnAdjustCallBack() {
            @Override
            public void adJustSelectPaintColor(int columnIndex, int rowIndex) {

                //回调当前的选中项所在的行与列
                Log.i("Info","Column="+columnIndex+"   rowIndex="+rowIndex);
            }
        });
    }

    private ArrayList<ArrayList<String>> createContent(int row, int column) {
        ArrayList<ArrayList<String>> results = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            ArrayList<String> strings = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                strings.add("$" + i + "" + j);
            }
            results.add(strings);
        }
        return results;
    }

    private ArrayList<String> createTopTitles() {
        ArrayList<String> results = new ArrayList<>();
        for (String string : topTitles) {
            results.add(string);
        }
        return results;
    }

    private ArrayList<String> createLeftTitle() {
        ArrayList<String> results = new ArrayList<>();
        for (int i = 9; i < 23; i++) {
            //results.add(i + ":00");
            results.add("");
        }


        return results;
    }


}
