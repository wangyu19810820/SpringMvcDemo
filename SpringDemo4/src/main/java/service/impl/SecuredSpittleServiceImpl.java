package service.impl;

import model.Spittle;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import service.SecuredSpittleService;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SecuredSpittleServiceImpl implements SecuredSpittleService {

//  @Secured({"ROLE_SPITTER", "ROLE_admin"})
//  @RolesAllowed("ROLE_admin")
//  @PreAuthorize("(hasRole('ROLE_admin') and #spittle.message.length() < 5)")
  public void addSpittle(Spittle spittle) {
    System.out.println("addSpittle Method was called successfully");
  }

//  @Secured({"ROLE_user"})
//  @PostAuthorize("hasRole('ROLE_user') and returnObject.message.contains(principal.username)")
  public Spittle showSpittle() {
    System.out.println("showSpittle Method was called successfully");
    Spittle spittle = new Spittle();
    spittle.setMessage("hello user");
    return spittle;
  }

  public void addSpittleList(List<Spittle> spittleList) {
    System.out.println("addSpittleList Method was called successfully");
    System.out.println(spittleList);
  }

  public List<Spittle> showList() {
    System.out.println("showList Method was called successfully");
    List list = new ArrayList();

    Spittle spittle1 = new Spittle();
    spittle1.setName("user");
    list.add(spittle1);

    Spittle spittle2 = new Spittle();
    spittle2.setName("admin");
    list.add(spittle2);

    Spittle spittle3 = new Spittle();
    spittle3.setName("aaa");
    list.add(spittle3);
    return list;
  }

  public void deleteSpittle(List<Spittle> spittleList) {
    System.out.println("deleteSpittle Method was called successfully");
    System.out.println(spittleList);
  }
}
