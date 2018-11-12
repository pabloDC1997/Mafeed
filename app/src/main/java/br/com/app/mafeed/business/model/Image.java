package br.com.app.mafeed.business.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "image", strict = false)
public class Image {

    @Element(name = "url", required = false)
    private String url;

    @Element(name = "title", required = false)
    private String title;

    @Path("link")
    @Text(required=false)
    private String link;

    @Element(name = "width", required = false)
    private int width;

    @Element(name = "height", required = false)
    private int height;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
