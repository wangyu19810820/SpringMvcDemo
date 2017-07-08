package service.impl;

import model.Spittle;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import service.SecuredSpittleService;

import javax.annotation.security.RolesAllowed;

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

}
