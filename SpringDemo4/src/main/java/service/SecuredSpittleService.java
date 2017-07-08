package service;

import model.Spittle;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;

import javax.annotation.security.RolesAllowed;
import java.util.List;

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

    @Secured({"ROLE_admin"})
    @PreFilter("filterObject.name == principal.username")
    void addSpittleList(List<Spittle> spittleList);

    @PostFilter("filterObject.name == principal.username")
    List<Spittle> showList();

    @PreFilter("hasPermission(filterObject, 'delete')")
    void deleteSpittle(List<Spittle> spittleList);
}
