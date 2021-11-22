package Controllers;

import Models.Activity;
import Models.ActivityAll;
import Models.ActivityData;
import Models.CestaData;
import Models.Entity;
import Models.EntityData;
import Models.MyAuthenticationProvider;
import Models.Student;
import Models.StudentData;
import Models.UserManager;
import Utils.Constants;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ActivityController {

    ActivityData activityData = new ActivityData();
    EntityData entityData = new EntityData();
    CestaData cestaData = new CestaData();
    StudentData studentData = new StudentData();

    AuthenticationProvider myprovider;
    UserManager usermanager;

    public ActivityController() {
        this.myprovider = new MyAuthenticationProvider();
        this.usermanager = new UserManager();
    }

    @RequestMapping(value = "/Activity/list", method = RequestMethod.GET)
    public ModelAndView listActivity() {
        ModelAndView view;
        List<Activity> activity = activityData.getAllActivitys();
        List<ActivityAll> activitys = new ArrayList<>();
        activity.stream().map(ac -> {
            ActivityAll activityAll = new ActivityAll();
            activityAll.setId_activity(ac.getId_activity());
            activityAll.setEntity(entityData.getEntityId(ac.getId_entity()));
            activityAll.setName(ac.getName());
            activityAll.setDate_ini(ac.getDate_ini());
            activityAll.setDate_fin(ac.getDate_fin());
            return activityAll;
        }).forEachOrdered(activityAll -> {
            activitys.add(activityAll);
        });
        UserDetails user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            user = (UserDetails) authentication.getPrincipal();
        }
        String rol = user != null ? user.getAuthorities().iterator().next().getAuthority() : "";
        if (rol.equals(Constants.ROLE_USER)) {
            Student student = studentData.getStudentId(user!=null?user.getUsername():"");
            view = new ModelAndView("ActivityAll", "activitys", activitys);
            view.addObject("countCart", cestaData.getCountCart(student!=null?student.getId_student():0));             
        } else {
            view = new ModelAndView("Activity", "activitys", activitys);            
        }
        return view;
    }

    @RequestMapping(value = "Activity/register", method = RequestMethod.GET)
    public ModelAndView register(@RequestParam(value = "registerError", required = false, defaultValue = "false") String registerError) {
        List<Entity> entitys = entityData.getAllEntitys();
        ModelAndView view = new ModelAndView("ActivityRegister");
        view.addObject(new Activity());
        view.addObject("entitys", entitys);
        view.addObject("title", "Register New Activity");
        if (registerError.equals("true")) {
            view.addObject("registerError", "true");
        }
        return view;
    }

    @RequestMapping(value = "/Activity/save", method = RequestMethod.POST)
    public String register(@Validated Activity activity) {
        activityData.saveActivity(activity);
        return "redirect:/Activity/list";
    }

    @RequestMapping(value = "/Activity/delete", method = RequestMethod.GET)
    public String supprimer(@RequestParam int id, HttpSession session) {
        boolean exists = activityData.existsActivity(id);
        if (exists) {
            return "redirect:/Activity/error";
        } else {
            activityData.deleteActivity(id);
        }
        return "redirect:/Activity/list";
    }

    @RequestMapping(value = "/Activity/error", method = RequestMethod.GET)
    public ModelAndView error(@RequestParam(value = "registerError", required = false, defaultValue = "false") String registerError) {
        ModelAndView view = new ModelAndView("MessageAndError");
        view.addObject("mensaje", Constants.MSG_NOT_DELETE);
        view.addObject("url", "/Activity/list");
        return view;
    }

    @RequestMapping(value = "Activity/edit/{id_activity}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id_activity, @RequestParam(value = "registerError", required = false, defaultValue = "false") String registerError) {
        List<Entity> entitys = entityData.getAllEntitys();
        ModelAndView view = new ModelAndView("ActivityRegister");
        view.addObject(activityData.getActivityId(id_activity));
        view.addObject("title", "Update Activity");
        view.addObject("entitys", entitys);
        if (registerError.equals("true")) {
            view.addObject("registerError", "true");
        }
        return view;
    }

    @RequestMapping(value = "Activity/addCesta/{id_activity}", method = RequestMethod.GET)
    public String addCesta(HttpServletRequest req, @PathVariable int id_activity, @RequestParam(value = "registerError", required = false, defaultValue = "false") String registerError) {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = studentData.getStudentId(user.getUsername());
        if(student!=null && student.getId_student()!=0 && !cestaData.existsActivity(student.getId_student(), id_activity)){            
            cestaData.addToCesta(student.getId_student(), id_activity, "");
        }      
        return "redirect:/Activity/list";
    }
}
