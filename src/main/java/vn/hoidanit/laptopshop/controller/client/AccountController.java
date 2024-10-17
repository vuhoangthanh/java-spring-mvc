package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UploadService;
import vn.hoidanit.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AccountController {

    public final UserService userService;
    public final UploadService uploadService;

    public AccountController(UserService userService, UploadService uploadService) {
        this.userService = userService;
        this.uploadService = uploadService;
    }

    @GetMapping("/information")
    public String getInfoPage(Model model, HttpServletRequest request) {
        // User currentUser = new User();// null
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");
        // currentUser.setId(id);

        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "client/information/show";
    }

    @GetMapping("/info/update")
    public String getUpdateInfoPage(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");

        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "client/information/update";
    }

    @PostMapping("/info/update")
    public String handleUpdateInfo(@ModelAttribute("user") User user,
            BindingResult newProductBindingResult,
            @RequestParam("avatarFile") MultipartFile file) {

        User currentUser = this.userService.getUserById(user.getId());
        if (currentUser != null) {
            if (!file.isEmpty()) {
                String img = this.uploadService.handleSaveUploadFile(file, "avatar");
                currentUser.setAvatar(img);
            }
            currentUser.setFullName(user.getFullName());
            currentUser.setEmail(user.getEmail());
            currentUser.setAddress(user.getAddress());
            currentUser.setPhone(user.getPhone());

            this.userService.handleSaveUser(currentUser);
        }

        return "redirect:/information";
    }

}
