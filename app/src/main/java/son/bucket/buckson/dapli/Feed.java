package son.bucket.buckson.dapli;

public class Feed {
    private User writer;
    private String title, context;
    private int num_likes;

    // Constructor
    public Feed(){}
    public Feed(String _title, String _context, User _writer){
        this.title = _title;
        this.context = _context;
        this.writer = _writer;
        this.num_likes = 0;
    }
}
