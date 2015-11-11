package com.example.emundo.cs390_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import android.view.View;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

public class UsersList extends AppCompatActivity {

    ListView userList;
    ArrayAdapter<String> adapter;
    ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);

        userList = (ListView) findViewById(R.id.UserListBox);

        String[] items={"Alex","Drew","Emmundo"};
        itemList=new ArrayList<String>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.txtview,itemList);
        userList.setAdapter(adapter);

        //sample code for dynamically adding elements to list
        //itemList.add("HelloWorld");
        // notify listview of data changed
        //adapter.notifyDataSetChanged();

        userList.setOnItemClickListener(new ListClickHandler());

        /*userList.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?>adapter,View v, int position){

                //ItemClicked item = adapter.getItem(position);

                startActivity(new Intent(UsersList.this, MessagingActivity.class));

            }


        });*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_users_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class ListClickHandler implements OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
            // TODO Auto-generated method stub

            // create intent to start another activity
            Intent intent = new Intent(UsersList.this, MessagingActivity.class);
            // add the selected text item to our intent
            startActivity(intent);

        }

    }
}
