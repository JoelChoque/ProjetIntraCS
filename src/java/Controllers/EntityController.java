package Controllers;

import Models.Activity;
import Models.ActivityData;
import Models.Entity;
import Models.EntityData;
import Models.MyAuthenticationProvider;
import Models.UserManager;
import Utils.Constants;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EntityController {

    AuthenticationProvider myprovider;
    UserManager usermanager;

    EntityData entityData = new EntityData();
    ActivityData activityData = new ActivityData();

    public EntityController() {
        this.myprovider = new MyAuthenticationProvider();
        this.usermanager = new UserManager();
    }

    @RequestMapping(value = "/Entity/list", method = RequestMethod.GET)
    public ModelAndView listEntity() {
        List<Entity> entitys = entityData.getAllEntitys();
        return new ModelAndView("Entity", "entitys", entitys);
    }

    @RequestMapping(value = "Entity/register", method = RequestMethod.GET)
    public ModelAndView register(@RequestParam(value = "registerError", required = false, defaultValue = "false") String registerError) {
        ModelAndView view = new ModelAndView("EntityRegister");
        view.addObject(new Entity());
        view.addObject("title", "Register New Entity");
        if (registerError.equals("true")) {
            view.addObject("registerError", "true");
        }
        return view;
    }

    @RequestMapping(value = "/Entity/save", method = RequestMethod.POST)
    public String register(@Validated Entity entity) {
        entityData.saveEntity(entity);
        return "redirect:/Entity/list";
    }

    @RequestMapping(value = "/Entity/delete", method = RequestMethod.GET)
    public String supprimer(@RequestParam int id, HttpSession session) {
        Activity activity = activityData.getActivityIdEdentity(id);
        if (activity == null) {
            entityData.deleteEntity(id);
        } else {
            return "redirect:/Entity/error";
        }
        return "redirect:/Entity/list";
    }

    @RequestMapping(value = "/Entity/error", method = RequestMethod.GET)
    public ModelAndView error(@RequestParam(value = "registerError", required = false, defaultValue = "false") String registerError) {
        ModelAndView view = new ModelAndView("MessageAndError");
        view.addObject("mensaje",Constants.MSG_NOT_DELETE);
        view.addObject("url", "/Entity/list");
        return view;
    }

    @RequestMapping(value = "Entity/edit/{id_entity}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id_entity, @RequestParam(value = "registerError", required = false, defaultValue = "false") String registerError) {
        ModelAndView view = new ModelAndView("EntityRegister");
        view.addObject(entityData.getEntityId(id_entity));
        view.addObject("title", "Update Entity");
        if (registerError.equals("true")) {
            view.addObject("registerError", "true");
        }
        return view;
    }
    
    

}
