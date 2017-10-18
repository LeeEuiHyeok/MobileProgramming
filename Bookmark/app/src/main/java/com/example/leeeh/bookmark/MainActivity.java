package com.example.leeeh.bookmark;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView m_ListView;
    private ArrayAdapter<String> m_Adapter;
    TextFileManager tfm = new TextFileManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ArrayList<String> values = new ArrayList<>();
        for (String i : fileList()){
            values.add(i);
        }

        // Android에서 제공하는 String 문자열 하나를 출력하는 layout으로 어댑터 생성
        m_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);

        // Xml에서 추가한 ListView의 객체
        m_ListView = (ListView) findViewById(R.id.list);

        // ListView에 어댑터 연결
        m_ListView.setAdapter(m_Adapter);

        // ListView 아이템 터치 시 이벤트를 처리할 리스너 설정
        m_ListView.setOnItemClickListener(onClickListItem);
        m_ListView.setOnItemLongClickListener(onLongClickListItem);

        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
//              Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddBookmark.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private AdapterView.OnItemClickListener onClickListItem = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = null;
            // 이벤트 발생 시 해당 아이템 위치를 텍스트로 출력
            String url = tfm.load(m_Adapter.getItem(position).toString());
//            Toast.makeText(getApplicationContext(), m_Adapter.getItem(position), Toast.LENGTH_SHORT).show();
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + url));

            if(intent != null) {
                if(intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        }

    };
    private AdapterView.OnItemLongClickListener onLongClickListItem = new AdapterView.OnItemLongClickListener() {

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            tfm.delete(m_Adapter.getItem(position).toString());
            m_Adapter.remove(m_Adapter.getItem(position).toString());
            Toast.makeText(getApplicationContext(), "삭제 완료", Toast.LENGTH_SHORT).show();

            return true;
        }
    };

}
