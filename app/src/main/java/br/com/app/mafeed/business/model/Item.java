package br.com.app.mafeed.business.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.util.Date;

@Root(name = "item", strict = false)
public class Item {

    @Element(name = "title", required = false)
    private String title;

    @Path("link")
    @Text(required=false)
    private String link;

    @Element(data=true, name = "description", required = false)
    private String description;

    @Element(name = "category", required = false)
    private String category;

    @Element(name = "pubDate", required = false)
    private String pubDate;

    @Element(name = "content", required = false)
    @Namespace(prefix="media")
    private Content content;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
