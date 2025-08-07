import { Api } from "../axios-config";

type AuthResponse = {
    token: string;
};

type AuthCredentials = {
    login: string;
    senha: string;
};

const auth = async (credentials: AuthCredentials): Promise<AuthResponse> => {
    try {
        const { data } = await Api.post<AuthResponse>('/auth/login', credentials);
        return data;
    } catch (error: any) {
        throw error;
    }
};

export const AuthService = {
    auth
};
