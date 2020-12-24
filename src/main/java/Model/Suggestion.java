package Model;

import Model.Acount.Account;
import Model.Data.Data;
import Model.Tools.Packable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Suggestion implements Packable<Suggestion> {
    private long suggestionId;
    private long accountId;
    private long gameId;
    private static List<Suggestion> suggestionList =new ArrayList<>();
    private HashMap<Long, Long> suggestionGameHashMap;



    /********************** add and remove *******************/
    public void addSuggestion(Account account,Game gameId){
        suggestionGameHashMap.put(getAccountId(),getGameId());
        Database.save(this);
    }
    public void removeSuggestion(Account account,Game gameId){
        suggestionGameHashMap.remove(account,gameId);
        Database.remove(this);


    }

/************ getter and setter **************/
    public long getSuggestionId() {
        return suggestionId;
    }

    public long getAccountId() {
        return accountId;
    }

    public long getGameId() {
        return gameId;
    }

    public HashMap<Long, Long> getSuggestionGameHashMap() {
        return suggestionGameHashMap;
    }

    public void setSuggestionId(long suggestionId) {
        this.suggestionId = suggestionId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public void setSuggestionGameHashMap(HashMap<Long, Long> suggestionGameHashMap) {
        this.suggestionGameHashMap = suggestionGameHashMap;
    }

    public static List<Suggestion> getSuggestionList() {
        return Collections.unmodifiableList(suggestionList);
    }

    public void setSuggestionList(List<Suggestion> suggestionList) {
        this.suggestionList = suggestionList;
    }

    /******************* pack and data ***************/

   @Override
    public Data<Suggestion> pack(){
       return new Data<Suggestion>()
               .addField(suggestionId)
               .addField(accountId)
               .addField(gameId)
               .addField(suggestionList)
               .addField(suggestionGameHashMap)
               .setInstance(new Suggestion());
   }

   public Suggestion dpkg(Data<Suggestion> data){
       this.accountId=(long) data.getFields().get(0);
       this.suggestionId = (long) data.getFields().get(1);
       this.suggestionList = (List<Suggestion>) data.getFields().get(2);
       this.suggestionGameHashMap = (HashMap<Long, Long>) data.getFields().get(3);
       this.gameId = (long) data.getFields().get(4);
       return this;
   }

    @Override
    public long getId() {
        return 0;
    }
/******************************** constructor*********************************/
    public Suggestion(long suggestionId, long accountId, long gameId) {
        this.suggestionId = suggestionId;
        this.accountId = accountId;
        this.gameId = gameId;
    }

    public Suggestion() {

    }
}
