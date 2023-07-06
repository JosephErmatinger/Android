//Name/Date:  Joseph Ermatinger 11/4/2019;
//Instructor: Hira Harrington;
//Course:     ISYS 221 VL;
//Purpose:    The purpose of this program is to create a mobile application for the Jim Crow Museum Website using the master/detail flow template.
//Inputs:     This program accepts user input in the form of a list item selection which results in a detail view of the item.
//Outputs:    TextView & ImageView controls will be output to the screen when an item is selected and if the 5th item is selected a WebView control will be output to the screen;
//Interfaces: N/A;
//Variables:  id;        String; assign list item id;
//            content;   String; assign list item content;
//            item_name; String; assign list item name;
//            item_url;  String; assign list item url;
package com.example.myapplication.dummy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Helper class for providing sample content for user interfaces created by Android template wizards.
//TODO: Replace all uses of this class before publishing your app.
public class DummyContent {

    // An array of sample (dummy) items.
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    // A map of sample (dummy) items, by ID.
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        addItem(new DummyItem("1", "Exhibit 1"));
        addItem(new DummyItem("2", "Exhibit 2"));
        addItem(new DummyItem("3", "Exhibit 3"));
        addItem(new DummyItem("4", "Exhibit 4"));
        addItem(new DummyItem("5", "Web Site", "https://www.ferris.edu/HTMLS/news/jimcrow/index.htm"));
    }
    //add items to item map
    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }
    //create list of dummy items with position
    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Exhibit " + position, makeDetails(position));
    }
    //uses string builder to append item details
    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
    // A dummy item representing a piece of content.
    public static class DummyItem {
        //variable declarations
        public String id;
        public String content;
        public String item_name;
        public String item_url;

        //parameterized constructor that accepts item id & content
        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }
        //parameterized constructor that accepts url to display web page
        public DummyItem(String id, String item_name, String item_url) {
            {
                this.id = id;
                this.item_name = item_name;
                this.item_url = item_url;
                content = item_name;
            }
        }
        @Override
        //return string of content
        public String toString() { return content; }
    }
}
