package com.bdoks54.googledistance04view01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //도시 목록을 저장하기 위해 ArrayList<ClockCity>를 선언 , 생성한다
    private ArrayList<ClockCity> cities = new ArrayList<ClockCity>();
    //도시목록을 보이기 위한 리스트뷰
    private ListView listView;
    //어댑터를 선언한다
    private CitiesAdapter citiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getCities();    //도시목록 가져오기
        Toast.makeText(this, "Ready~~~~", Toast.LENGTH_LONG).show();
        showComponent();    //어댑터를 이용하여 리스트뷰에 보여주기

    }

    public void showComponent() {
        listView = findViewById(R.id.listView);
        citiesAdapter = new CitiesAdapter(this, cities);
        //리스트뷰에 어댑터를 설정한다
        listView.setAdapter(citiesAdapter);
        //리스트의 한 아이템을 누르면 선택된 도시의 정보를 토스트로 보여준다.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //선택된 도시 정보 -> 아이템
                ClockCity eq = (ClockCity) parent.getItemAtPosition(position);
                String latlng = String.format("%s, %s,[%f,%f]",
                        eq.getTimezoneId(), eq.getCountryName(), eq.getLat(), eq.getLng());
                Toast.makeText(getApplicationContext(), latlng, Toast.LENGTH_LONG).show();
            }
        });
    }
    //도시목록을 만든다
    public void getCities() {
        cities.clear();
        cities.add(new ClockCity(37.5670, 126.9807, "Asia/Seoul", "Korea"));
        cities.add(new ClockCity(47.01, 10.2, "Europe/Vienna", "Austria"));
        cities.add(new ClockCity(40.714086, -74.228697, "America/New_York", "US"));
        cities.add(new ClockCity(19.42847, -99.12766, "America/Mexico_City", "Mexico"));
    }

    public void refreshView(){
        refreshViewHandler.sleep(1000*60);
        cities = new ArrayList<ClockCity>();
        getCities();
        citiesAdapter.clear();
        citiesAdapter.addAll(cities);
    }

    private RefreshViewHandler refreshViewHandler = new RefreshViewHandler();

    class RefreshViewHandler extends Handler{
        @Override
        public void handleMessage(Message msg){
            refreshView();
        }
        public void sleep(long delayMillis){
            this.removeMessages(0);
            sendMessageDelayed(obtainMessage(0), delayMillis);
        }
    };
}