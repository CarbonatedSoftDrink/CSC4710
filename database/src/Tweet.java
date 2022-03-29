public class Tweet {
    protected int id;
    protected String Content;
    protected String Author;
    //protected int TweeterID;
    //protected int ParentTweetID;

    public Tweet() {
    }

    public Tweet(int id) {
        this.id = id;
    }
    
    public Tweet (int id, String Content, String Author){
        this(Content, Author);
        this.id = id;
    }
    
    public Tweet (String Content, String Author){
        this.Content = Content;
        this.Author = Author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public String getAuthor() {
    	return Author;
    }
    
    public void setAuthor(String author) {
    	this.Author = author;
    }
}
