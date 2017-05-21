package service;

import model.Spittle;

import java.util.List;

/**
 * Created by admin on 2017/5/18.
 */
public interface SpittleService {
    List<Spittle> findSpittle(long max, int count);
    Spittle findById(long id);
}
