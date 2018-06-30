package son.bucket.buckson.dapli;

import org.json.JSONObject;

import java.util.ArrayList;

public class FeedList {
    private ArrayList<Feed> feed_list;

    // Constructor
    public FeedList(){feed_list = new ArrayList<Feed>();}
    public FeedList(ArrayList<Feed> _feed_list){
        this.feed_list = _feed_list;
    }
    public FeedList(JSONObject _feed_list){
        feed_list = new ArrayList<Feed>();
        String feed_list_Str = _feed_list.toString();
        feed_list_Str.substring(1,feed_list_Str.length()-1);
        String[] feed_str_array = feed_list_Str.split(",");
        for(String feed_str : feed_str_array){
            feed_str.substring(1, feed_str.length()-1);
            feed_str.split(",");
            // Need to revise feed constructing
            Feed entry = new Feed();
            feed_list.add(entry);
        }

    }
    // Methods
    public int get_feed_list_size(){return feed_list.size();}
    public void add_feed(Feed entry){feed_list.add(entry);}
}


/*

            FeedData("치앙마이 여행", "쪄죽을뻔 했지만 그래도 친구들과 드라이빙 하면서 좋은 시간을 보낸것 같다.", R.drawable.profile, "10002"),
            FeedData("Marvin Gaye", "Charlie Puth", R.drawable.profile, "12312"),
            FeedData("MIC DROP", "BTS", R.drawable.profile,"11551"
 */