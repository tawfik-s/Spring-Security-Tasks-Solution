package com.shalash.task7;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String getRootPage(Authentication authentication) {
        return "hello, user "+authentication.getName();
    }


    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String getUserPage(Authentication authentication) {
        return "hello, user " + authentication.getName() +
               " with roles: " + authentication.getAuthorities();
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String getAdminPage(Authentication authentication) {
        return "hello, admin "+authentication.getName()+ " at user admin page";
    }


    @GetMapping("/book/{id}")
    @PostAuthorize("returnObject != null and returnObject.owner == authentication.name")
    public Book getBook(@PathVariable int id) {
        return bookService.getBookById(id);
    }
}
