package urlShortner;

import urlShortner.exception.URLDoesNotExist;
import urlShortner.storage.Storage;
import urlShortner.storage.StorageImpl;
import urlShortner.urlshortner.ShortnerService;
import urlShortner.urlshortner.ShortnerServiceImpl;

public class Executor {

    public static void main(String[] args) throws URLDoesNotExist {

        Storage storage = new StorageImpl();

        ShortnerService shortnerService = new ShortnerServiceImpl(storage,8);

        String hvalue = shortnerService.shortURL("https://harshvardhansingh.com");

        System.out.println(hvalue);

        System.out.println(shortnerService.getURL(hvalue));

        System.out.println(shortnerService.getURL("abcd"));

    }
}
