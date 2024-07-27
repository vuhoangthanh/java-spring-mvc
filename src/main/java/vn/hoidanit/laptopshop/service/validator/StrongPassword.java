package vn.hoidanit.laptopshop.service.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = StrongPasswordValidator.class) // đây là 1 anotasion vs mục đích validate dữ liệu
@Target({ ElementType.METHOD, ElementType.FIELD }) // xác định xem phạm vi hoạt động (validate trên một trường thông tin
                                                   // hay trên 1 class)
@Retention(RetentionPolicy.RUNTIME) // khi naof chayj casi nayf(khi dự án chạy : runtime)
@Documented
public @interface StrongPassword {
    String message() default "Must be 8 characters long and combination of uppercase letters, lowercase letters, numbers, special characters.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

// tạo anotation Strong Password