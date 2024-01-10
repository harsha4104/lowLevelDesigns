package urlShortner.urlshortner;

import urlShortner.exception.URLDoesNotExist;
import urlShortner.storage.Storage;

import java.util.*;
import java.util.Base64;
import java.util.Random;

public class ShortnerServiceImpl implements ShortnerService{

    Storage storage;
    int sequenceNumber;

    int hashLimit;

    public ShortnerServiceImpl(Storage storage, int hashLimit){
        this.storage = storage;
        this.sequenceNumber = 0;
        this.hashLimit = hashLimit;
    }
    @Override
    public String shortURL(String url) {
        while(true){
            String hashValue = getHashValue();
            if(storage.getUrl(hashValue) == null){
                storage.storeUrl(hashValue, url);
                return hashValue;
            }
        }
    }

    @Override
    public String getURL(String hashValue) throws URLDoesNotExist {
        if(storage.getUrl(hashValue) == null){
            throw new URLDoesNotExist("URL does not exist");
        }

        return storage.getUrl(hashValue);
    }

    private String getHashValue(){
        String salt = "HiI'mURLShortner";
        salt += String.valueOf(sequenceNumber);
        List<Character> list = new ArrayList<>();
        fillatoz(list);
        fillAtoZ(list);
        fill0to9(list);

        List<Character> hashCharList = new ArrayList<>();
        for(int i=0;i<hashLimit;i++){
            int index = new Random().nextInt(list.size());
            hashCharList.add(list.get(index));
        }

        String hvalue = "";
        for(Character c: hashCharList){
            hvalue += c;
        }
        return hvalue;

    }

    private void fillatoz(List<Character> list){
        for(int i=0;i<26;i++){
            list.add((char)(i+'a'));
        }
    }
    private void fillAtoZ(List<Character> list){
        for(int i=0;i<26;i++){
            list.add((char)(i+'A'));
        }
    }
    private void fill0to9(List<Character> list){
        for(int i=0;i<10;i++){
            list.add((char)(i+'0'));
        }
    }
}
