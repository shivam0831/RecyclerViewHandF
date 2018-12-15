package com.shivam.recyclerviewhandf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.shivam.recyclerviewhandf.adapter.Adapter;
import com.shivam.recyclerviewhandf.models.Footer;
import com.shivam.recyclerviewhandf.models.Header;
import com.shivam.recyclerviewhandf.models.Item;
import com.shivam.recyclerviewhandf.models.RecyclerViewItem;
import com.shivam.recyclerviewhandf.utils.Space;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //init RecyclerView
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //add space item decoration and pass space you want to give
        recyclerView.addItemDecoration(new Space(20));
        //finally set adapter
        recyclerView.setAdapter(new Adapter(createDummyList(), this));


    }

    //Method to create dummy data
    private List<RecyclerViewItem> createDummyList() {
        List<RecyclerViewItem> recyclerViewItems = new ArrayList<>();
        Header header = new Header("Welcome To Bucket", "Image",
                "https://cdn.pixabay.com/photo/2017/09/30/15/10/pizza-2802332_640.jpg");
        //add header
        recyclerViewItems.add(header);
        String[] imageUrls = {"https://cdn.pixabay.com/photo/2016/11/18/17/42/barbecue-1836053_640.jpg",
                "https://cdn.pixabay.com/photo/2016/07/11/03/23/chicken-rice-1508984_640.jpg",
                "https://cdn.pixabay.com/photo/2017/03/30/08/10/chicken-intestine-2187505_640.jpg",
                "https://cdn.pixabay.com/photo/2017/02/15/15/17/meal-2069021_640.jpg",
                "https://cdn.pixabay.com/photo/2017/06/01/07/15/food-2362678_640.jpg"};
        String[] titles = {"5 in 1 Chicken Zinger Box",
                "Paneer Butter Masala",
                "Chicken Lollipop Masala", "Paneer Manchurian", "Non-Veg. Lemon & Coriander Soup"};
        String[] descriptions = {"Chicken zinger+hot wings [2 pieces]+veg strip [1 piece]+Pillsbury cookie cake+Pepsi [can]",
                "A spicy North Indian dish made from cottage cheese, cream, butter and select spices",
                "Chicken wings coated with batter of flour",
                "Deep-fried cottage cheese balls sautéed with ginger", "Meat shreds, lime juice and coriander"};

        for (int i = 0; i < imageUrls.length; i++) {
            Item item = new Item(titles[i], descriptions[i], imageUrls[i]);
            //add food items
            recyclerViewItems.add(item);
        }

        Footer footer = new Footer("Your diet is a bank account. Good food choices are good investments.",
                "Bethenny Frankel", "https://cdn.pixabay.com/photo/2017/09/30/15/10/pizza-2802332_640.jpg");
        //add footer
        recyclerViewItems.add(footer);
        return recyclerViewItems;
    }

}
