import { useEffect, useState } from 'react';
import {
    Box,
    Button,
    TextField,
    Typography,
    Snackbar,
    Alert,
} from '@mui/material';
import { AuthController } from './authController';
import { useNavigate } from 'react-router-dom';

export default function Login() {
    const navigate = useNavigate();

    const [login, setLogin] = useState('');
    const [senha, setSenha] = useState('');

    const [snackbarOpen, setSnackbarOpen] = useState(false);
    const [snackbarMessage, setSnackbarMessage] = useState('');

    useEffect(() => {
        if (AuthController.isAuthenticated()) {
            navigate('/home');
        }
    }, []);

    const handleLogin = async (event: React.FormEvent) => {
        event.preventDefault();

        try {
            await AuthController.login({ login, senha });
            navigate('/home');
        } catch (error: any) {
            setSnackbarMessage(error.message);
            setSnackbarOpen(true);
        }
    };

    const handleCloseSnackbar = () => {
        setSnackbarOpen(false);
    };

    return (
        <Box
            display="flex"
            justifyContent="center"
            alignItems="center"
            minHeight="100vh"
        >
            <Box display="flex" flexDirection="column" alignItems="center">
                <Typography variant="h3" align="center" gutterBottom>
                    BNInovações
                </Typography>

                <Box component="form" onSubmit={handleLogin}>
                    <Box
                        alignItems="center"
                        display="flex"
                        flexDirection="column"
                        minWidth="300px"
                        maxWidth="500px"
                    >
                        <TextField
                            fullWidth
                            label="Login"
                            variant="outlined"
                            name="login"
                            value={login}
                            onChange={(e) => setLogin(e.target.value)}
                        />

                        <TextField
                            fullWidth
                            label="Senha"
                            type="password"
                            variant="outlined"
                            name="password"
                            value={senha}
                            onChange={(e) => setSenha(e.target.value)}
                        />

                        <Button
                            type="submit"
                            variant="contained"
                            fullWidth
                        >
                            Entrar
                        </Button>
                    </Box>
                </Box>

                <Snackbar
                    open={snackbarOpen}
                    autoHideDuration={6000}
                    onClose={handleCloseSnackbar}
                    anchorOrigin={{ vertical: 'top', horizontal: 'center' }}
                >
                    <Alert onClose={handleCloseSnackbar} severity="error" sx={{ width: '100%' }}>
                        {snackbarMessage}
                    </Alert>
                </Snackbar>
            </Box>
        </Box>
    );
}
