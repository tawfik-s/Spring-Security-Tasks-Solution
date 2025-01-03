# Spring Security Tasks Solution

Test and enhance your Spring Security expertise with this comprehensive quiz!  
Each task challenges you to configure Spring Security for a specific use case, providing a hands-on approach to mastering real-world scenarios.  
## Spring Security Architecture diagram
![SpringSecurityArchitectureDiagram.svg](SpringSecurityArchitectureDiagram.svg)

## 🌟 Features  
- 📚 Practical tasks for mastering Spring Security.  
- 🛠️ Real-world use cases to boost your confidence.  
- 💡 Opportunity to experiment with different configurations.  

---

## 📝 Tasks Overview  

### 🔒 Task 1: Basic Authentication  
Configure a Spring Boot application with Spring Security to:  
- Require **username and password** authentication for all endpoints.  
- Use **in-memory user details** with roles `USER` and `ADMIN`.  

---

### 🛡️ Task 2: Role-Based Access Control  
Implement **role-based access control**:  
- `USER` can access `/user/**`.  
- `ADMIN` can access `/admin/**` and `/user/**`.  
- Restrict `/admin/**` to only `ADMIN` users.  

---

### ✨ Task 3: Custom Login Page  
- Create a **custom login page** to replace the default form-based login.  
- Redirect users to different pages after login based on their roles.  

---

### 🔑 Task 4: Password Encoding  
- Integrate a **password encoder** (e.g., `BCryptPasswordEncoder`) to hash and verify passwords stored in a database.  
- Use a **database** to manage user details instead of in-memory users.  

---

### 📜 Task 5: JWT Authentication  
- Configure the application to use **JWT** for authentication.  
- Implement **token generation and validation**.  
- Secure endpoints using JWT tokens.  
  > **Note**: The solution uses the JJWT library, but you can explore other options like Auth0.  

---

### 🌐 Task 6: OAuth2 Login  
- Set up **OAuth2 login** with GitHub as an identity provider.  
- Allow users to log in using their **GitHub accounts**.  

---

### 📋 Task 7: Method-Level Security  
- Enable **method-level security annotations**.  
- Use `@PreAuthorize` and `@PostAuthorize` to secure specific methods in a service.  

---

### 🔒 Task 8: CSRF Protection  
- Enable **CSRF protection** in the application.  
- Configure CSRF tokens for form submissions.  

---

### 🔐 Task 9: Multi-Factor Authentication  
- Add a second layer of authentication using an **OTP (One-Time Password)** system.  
- Use **Google Authenticator** or a similar app for generating OTPs.  

---

### ⚠️ Task 10: Exception Handling  
- Implement a **custom access denied page** for unauthorized resource access.  
- Configure custom exception handling for authentication failures.  

---

### 💾 Task 11: Remember Me  
- Add a "**Remember Me**" functionality to the login flow.  
- Ensure users can stay logged in even after closing their browser.  

---

### 🔄 Task 12: Security Context Propagation  
- Use Spring Security's `SecurityContext` to pass user details into a service layer.  
- Create a **custom user details service** to load user data from a database.  

---

### 📂 Task 13: LDAP Authentication  
- Configure the application to authenticate users against an **LDAP server**.  

---

### 🧪 Task 14: Security Testing  
- Write **unit tests** to verify the security configuration:  
  - Test access to endpoints with and without valid credentials.  
  - Mock user authentication for service-level tests.  

---

## 🛠️ How to Contribute  
Feel free to fork the repository, enhance the solutions, or even add new tasks!  

## 📢 Acknowledgments  
This project is inspired by the need to bridge the gap between learning concepts and applying them in real-world scenarios. Let's code securely!  

---

Happy Learning! 🎉
