package com.bdoks54.googledistance04view01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//ArrayAdapter를 상속한다
public class CitiesAdapter extends ArrayAdapter<ClockCity> {
    //액티비티에 대한 정보를 갖는 컨텍스트 선언
    private Context context;
    //리스트뷰에 표시할 도시 목록 선언
    private ArrayList<ClockCity> clockCities = new ArrayList<ClockCity>();
    //컨텍스트와 도시 목록을 대입받기 위한 생성자를 선언한다.
    public CitiesAdapter(Context context, ArrayList<ClockCity> values){
        super(context, android.R.layout.simple_list_item_1, values);
        //ArrayAdapter의 아이템즈의 레이아웃
        this.context = context; //컨텍스트 대입
        this.clockCities = values;  //도시 목록 대입
    }
    //각 아이템을 만들 getView()
    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //한 아이템의 레이아웃 준비
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_clock_item, parent, false);
        //position에 있는 한 도시의 정보
        ClockCity city = clockCities.get(position);  //getview(0) -> 도시목록.get(0)
        //item 하나에 대한 화면 뷰(컴포넌트) 객체 생성
        TextView tvtimezone = rowView.findViewById(R.id.tvtimezone);
        TextView tvtimes = rowView.findViewById(R.id.tvtimes);
        TextView tvlocation = rowView.findViewById(R.id.tvlocation);
        TextView tvlatlng = rowView.findViewById(R.id.tvlatlng);
        ClockView clockView = rowView.findViewById(R.id.clockview);
        clockView.setTimezoneId(city.getTimezoneId());  //타임존 넣기 America/New_York
        String latlng = String.format("%f,%f", city.getLat(), city.getLng());
        //데이터를 화면에 붙이기
        tvtimezone.setText(city.getTimezoneId());
        tvtimes.setText(clockView.getTimes());
        tvlocation.setText(city.getCountryName());
        tvlatlng.setText(latlng);   return rowView;
    }
}
