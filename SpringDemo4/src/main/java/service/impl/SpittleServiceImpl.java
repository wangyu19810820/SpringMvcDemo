package service.impl;

import model.Spittle;
import org.springframework.stereotype.Service;
import service.SpittleService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by admin on 2017/5/18.
 */
@Service
public class SpittleServiceImpl implements SpittleService {
    @Override
    public List<Spittle> findSpittle(long max, int count) {
        return Stream.iterate(max, num -> num - 1)
                .limit(count)
                .map(num -> new Spittle(num, "msg" + num, new Date()))
                .collect(Collectors.toList());
    }

    @Override
    public Spittle findById(long id) {
        return new Spittle(id, "msg" + id, new Date());
    }
}
