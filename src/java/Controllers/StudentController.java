package Controllers;

import Models.MyAuthenticationProvider;
import Models.Student;
import Models.StudentData;
import Models.Usager;
import Models.UserManager;
import Utils.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {

    AuthenticationProvider myprovider;
    UserManager usermanager;

    StudentData studentData = new StudentData();

    public StudentController() {
        this.myprovider = new MyAuthenticationProvider();
        this.usermanager = new UserManager();
    }

    @RequestMapping(value = "/Student/list", method = RequestMethod.GET)
    public ModelAndView listStudent() {
        List<Student> students = studentData.getAllStudents().stream()
                .map(s -> new Student(s.getId_student(), s.getName(), s.getEmail(), s.getTelephone(), "M".equals(s.getSexo()) ? "Male" : "Feminine"))
                .collect(Collectors.toList());
        return new ModelAndView("Student", "students", students);
    }

    @RequestMapping(value = "Student/register", method = RequestMethod.GET)
    public ModelAndView register(@RequestParam(value = "registerError", required = false, defaultValue = "false") String registerError) {
        ModelAndView view = new ModelAndView("StudentRegister");
        view.addObject(new Student());
        view.addObject("title", "Register New Student");
        if (registerError.equals("true")) {
            view.addObject("registerError", "true");
        }
        return view;
    }

    @RequestMapping(value = "/Student/save", method = RequestMethod.POST)
    public String register(@Validated Student student, HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (student.getId_student() == 0) {
            try {
                List<GrantedAuthority> authorities = new ArrayList();
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                Usager myuser = new Usager(username, password, true, student.getEmail(), authorities);
                student.setUsager(myuser);
                this.usermanager.createUser(myuser);
            } catch (IncorrectResultSizeDataAccessException ex) {
                return "redirect:Login/register?registerError=true";
            }
            studentData.saveStudent(student);
        } else {
            studentData.updateStudent(student);
        }

        return "redirect:/Student/list";
    }

    @RequestMapping(value = "/Student/delete", method = RequestMethod.GET)
    public String supprimer(@RequestParam int id, HttpSession session) {

        boolean exists = studentData.existsActivity(id);
        if (exists) {
            return "redirect:/Student/error";
        } else {
            studentData.deleteStudent(id);
        }
        return "redirect:/Student/list";

    }

    @RequestMapping(value = "/Student/error", method = RequestMethod.GET)
    public ModelAndView error(@RequestParam(value = "registerError", required = false, defaultValue = "false") String registerError) {
        ModelAndView view = new ModelAndView("MessageAndError");
        view.addObject("mensaje", Constants.MSG_NOT_DELETE);
        view.addObject("url", "/Student/list");
        return view;
    }

    @RequestMapping(value = "Student/edit/{idStudent}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int idStudent, @RequestParam(value = "registerError", required = false, defaultValue = "false") String registerError) {
        ModelAndView view = new ModelAndView("StudentRegister");
        view.addObject(studentData.getStudentId(idStudent));
        view.addObject("title", "Update Student");
        if (registerError.equals("true")) {
            view.addObject("registerError", "true");
        }
        return view;
    }

}
