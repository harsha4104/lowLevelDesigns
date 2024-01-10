package urlShortner.urlshortner;

import urlShortner.exception.URLDoesNotExist;

public interface ShortnerService {

    String shortURL(String url);

    String getURL(String hashValue) throws URLDoesNotExist;
}
