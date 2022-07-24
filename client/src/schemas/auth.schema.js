import { string, z } from "zod";

export const registerSchema = z
    .object({
        firstName: string({ required_error: "firstName is required" }),
        lastName: string({ required_error: "lastName is required" }),
        email: string({ required_error: "email is required" }).email("Enter a valid email"),
        password: string({ required_error: "password is required" }),
        confirmPassword: string({ required_error: "confirmPassword is required" }),
    })
    .refine((data) => data.password === data.confirmPassword, {
        message: "Passwords do not match",
        path: ["confirmPassword"],
    });

export const loginSchema = z.object({
    email: string({ required_error: "email is required" }).email("Enter a valid email"),
    password: string({ required_error: "password is required" }),
});
