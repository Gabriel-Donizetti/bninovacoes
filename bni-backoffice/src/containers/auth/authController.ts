import { AuthService } from "../../services/api/auth/authService";

type LoginCredentials = {
    login: string;
    senha: string;
};

export class AuthController {
    static async login(credentials: LoginCredentials): Promise<void> {
        try {
            const { token } = await AuthService.auth(credentials);

            localStorage.setItem("authToken", token);
            localStorage.setItem("login", credentials.login);
            localStorage.setItem("senha", credentials.senha);

        } catch (error: any) {
            throw new Error(error.response.data.error);
        }
    }

    static logout(): void {
        localStorage.removeItem("authToken");
    }

    static isAuthenticated(): boolean {
        return !!localStorage.getItem("authToken");
    }

    static getToken(): string | null {
        return localStorage.getItem("authToken");
    }
}
