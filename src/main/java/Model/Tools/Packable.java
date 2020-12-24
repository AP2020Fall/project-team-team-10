package Model.Tools;

import Exception.AccountDoesNotExistException;
import Exception.LogHistoryDoesNotExistException;
import Model.Data.Data;

public interface  Packable <T extends Packable<T>>{
    Data<T> pack();

   T dpkg(Data<T> data) throws AccountDoesNotExistException, LogHistoryDoesNotExistException, LogHistoryDoesNotExistException;

    long getId();
}
