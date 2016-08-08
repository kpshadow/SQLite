package android.zihang.com.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText inputText;
    TextView showText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = (EditText) findViewById(R.id.inputText);
        showText = (TextView)findViewById(R.id.showText);
        dbHandler = new MyDBHandler(this, null,null, 1);
        printDataBase();
    }

    //Add a product to the database
    public void addButtonClicked(View v){
        Products product = new Products(inputText.getText().toString());
        dbHandler.addProduct(product);
        printDataBase();
    }

    //Delete a product from the database
    public void deleteButtonClicked(View v){
        String Name = inputText.getText().toString();
        dbHandler.deleteProduct(Name);
        printDataBase();
    }


    public void printDataBase(){
        String dbString = dbHandler.databaseToString();

        showText.setText(dbString);
        inputText.setText("");
    }

}
