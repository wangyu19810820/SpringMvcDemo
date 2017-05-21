package service;

import model.Spittler;

/**
 * Created by admin on 2017/5/19.
 */
public interface SpittlerService {
    void register(Spittler spittler);
    Spittler get(long id);
}
