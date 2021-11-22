package Controllers;

import Models.Cesta;
import Models.CestaData;
import Models.Student;
import Models.StudentData;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CestaController {

    private final CestaData cestaData = new CestaData();
    private final StudentData studentData = new StudentData();
    @RequestMapping(value = "/Cesta/list", method = RequestMethod.GET)
    public ModelAndView getCestaAll() {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = studentData.getStudentId(user.getUsername());
        List<Cesta> activitys = cestaData.getAllCesta(student.getId_student());
        return new ModelAndView("Cesta", "activitys", activitys);
    }
    @RequestMapping(value = "/Cesta/listActivityStudent", method = RequestMethod.GET)
    public ModelAndView getActivityStudent(HttpServletRequest req) {
        List<Cesta> activitys = new ArrayList<>();
        return new ModelAndView("ActivityStudent", "activitys", activitys);
    }
    @RequestMapping(value = "/Cesta/listActivityStudent", method = RequestMethod.POST)
    public ModelAndView getActivityStudentPost(HttpServletRequest req) {
        int idStudent = Integer.valueOf(req.getParameter("txtIdStudent"));
        List<Cesta> activitys = cestaData.getAllCesta(idStudent);
        return new ModelAndView("ActivityStudent", "activitys", activitys);
    }
    @RequestMapping(value = "/Cesta/Activity/delete", method = RequestMethod.GET)
    public String deleteActivity(@RequestParam int idStudent,@RequestParam int idActivity) {
        cestaData.deleteEntity(idStudent, idActivity);
        return "redirect:/Cesta/list";
    }
    
    
}
