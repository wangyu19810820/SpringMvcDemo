package service;

import model.Spittle;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;

import javax.annotation.security.RolesAllowed;

/**
 * Created by admin on 2017/7/8.
 */
public interface SecuredSpittleService {

    @Secured({"ROLE_SPITTER", "ROLE_admin"})
    @RolesAllowed("ROLE_admin")
    @PreAuthorize("(hasRole('ROLE_admin') and #spittle.message.length() < 5)")
    void addSpittle(Spittle spittle);

    @Secured({"ROLE_user"})
    @PostAuthorize("hasRole('ROLE_user') and returnObject.message.contains(principal.username)")
    Spittle showSpittle();
}
