package service.impl;

import model.Spittler;
import org.springframework.stereotype.Service;
import service.SpittlerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/5/19.
 */
@Service
public class SpittlerServiceImpl implements SpittlerService {

    private List<Spittler> list = new ArrayList<>();

    @Override
    public void register(Spittler spittler) {
        Long max = list.stream()
                .mapToLong(Spittler::getId)
                .reduce(1, (l1, l2) -> l1 > l2 ? l1 : l2);
        spittler.setId(max + 1);
        list.add(spittler);
    }

    @Override
    public Spittler get(long id) {
        return list.stream().filter(s -> s.getId() == id).findAny().orElse(null);
    }
}
