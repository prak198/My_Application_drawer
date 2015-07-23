package app.demo2.myapplication;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] numbersystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize
        listView = (ListView) findViewById(R.id.left_drawer);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        //fetching array
        numbersystem = getResources().getStringArray(R.array.numbersystem);
        //putting value FROM JAVA for functionality using array adapter
        listView.setAdapter(new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, numbersystem));

        listView.setOnItemClickListener(this);



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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(), numbersystem[position]+""+"  is selected",
                Toast.LENGTH_SHORT).show();
        selectItem(position);
    }

    private void selectItem(int  position) {
        listView.setItemChecked(position,true);
        setTitle(numbersystem[position]);
    }

    public void setTitle(String title){
        getSupportActionBar().setTitle(title);
    }


}
