package br.com.app.mafeed.business.model;

public class FeedURL {
    private String url;
    private String base;
    private String endpoint;

    public FeedURL(String url) {
        this.base = buildBase(url);
        this.endpoint = buildEndpoint(url);
        this.url = buildUrl();
    }

    private String buildUrl() {
        return "http://" + this.base + this.endpoint;
    }

    private String buildEndpoint(String url) {
        return url.substring(url.indexOf("/")+1);    }

    private String buildBase(String url) {
        return url.substring(0,url.indexOf("/"));
    }

    public String getUrl() {
        return url;
    }

    public String getBase() {
        return base;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
