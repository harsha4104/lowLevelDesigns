package urlShortner.storage;

public interface Storage {

    void storeUrl(String hashValue, String url);

    void removeUrl(String hashValue);

    String getUrl(String hashValue);
}
