import React, { useState, useContext, useEffect } from 'react';
// import { useNavigate, Link } from 'react-router-dom';
import './LoginPageLayout.css';
import { TextField, Button, Alert, Collapse, Snackbar} from '@mui/material';
import IconButton from '@mui/material/IconButton';
import CloseIcon from '@mui/icons-material/Close';
import axios from 'axios';


const SignIn = () => {
    const [formData, setFormData] = useState({
        email: '',
        password: '',
      });
    const [isEmailValid, setIsEmailValid] = useState(true);
    const [isPasswordValid, setPasswordValid] = useState(true);
    const [userNotFound, setUserNotFound] = useState(false);
    const [incorrectPassword, setIncorrectPassword] = useState(false);
    const [openSnackbar, setOpenSnackbar] = useState(false);
    const [fieldsFilled, setFieldsFilled] = useState(false);
    const [success, setSuccess] = useState(false);
    const [error, setError] = useState(false);

    useEffect(() => {
        const filled =
          !!(formData.email &&
          formData.password);
        setFieldsFilled(filled);
      }, [formData]);

    const handleEmailChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const newEmail = e.target.value;
        setFormData({ ...formData, email: newEmail });

        validateEmail(newEmail);
    };

    const handlePasswordChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });

        let updatedPassword = formData.password;
    
        if (name === "password") {
            updatedPassword = value;
        }
    };

    const validateEmail = (emailInput: string) => {
        const emailRegex = /^(([^<>()[\].,;:\s@"]+(\.[^<>()[\].,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        setIsEmailValid(emailRegex.test(emailInput));
    };

    const resetAlerts = () => {
        setUserNotFound(false);
        setIncorrectPassword(false);
    };

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        console.log("Submitting form data...");
        e.preventDefault();
        
        const userData = {
            email: formData.email,
            password: formData.password
        };

        try {
            const response = await axios.post('http://localhost:8080/api/v1/users/login', userData);

            console.log(response.data);

            if (response.data === true) {
                console.log("User Signed In Successfully");
                setSuccess(true);
                setError(false);
                setUserNotFound(false);
                setFormData({
                    email: '',
                    password: ''
                });
                resetAlerts();

            } else {
                // Handle other statuses here, e.g. 401 for unauthorized
                console.log("Invalid credentials");
                setError(true);
            }
    
        } catch (error: any) {
            if ('response' in error) {
                console.error("There was an error signing in the user:", error.response);
                if (error.response.status === 404) {
                    setUserNotFound(true);
                }
                else if (error.response.status === 401) {
                    setIncorrectPassword(true);
                }
            setError(true);
            }
            
        } 
    };

    return (
        <div className='signInContainer'>
            <h1 className='signInHeader'>Grocery Title</h1>
            <p className='blurbText'>Sign in below for access to your profile </p>

            <TextField
                name="email"
                label="Email"
                variant="filled"
                margin="normal"
                className="textField"
                error={formData.email ? !isEmailValid : false}
                helperText={formData.email && !isEmailValid ? 'Please enter a valid email address.' : ''}
                value={formData.email}
                onChange={handleEmailChange}
                required
            />

            <TextField
                name="password"
                label="Password"
                type="password"
                variant="filled"
                margin="normal"
                className="textField"
                error={formData.password ? incorrectPassword : false}
                helperText={formData.password && incorrectPassword ? 'Incorrect password.' : ''}
                value={formData.password}
                onChange={handlePasswordChange}
                required
            />

            <form onSubmit={handleSubmit}>
            <Button 
                type="submit"
                variant="contained" 
                className="signInButton" 
                disabled={!(fieldsFilled && isEmailValid && isPasswordValid)}>
                Sign In
            </Button>
            </form>

            {/* <p className="signupPrompt">Don't have an account? <Link to="/signup" className="signupLink">Sign up now!</Link></p> */}


            <div className="alertSpace">
                <Collapse in={userNotFound}>
                    <Alert
                        severity='error'
                        action={
                            <IconButton
                                aria-label="close"
                                color="inherit"
                                size="small"
                                onClick={() => setUserNotFound(false)}
                            >
                                <CloseIcon fontSize="inherit" />
                            </IconButton>
                        }
                    >
                        No user found with this email address. Please sign up.
                    </Alert>
                </Collapse>
            </div>
            <Snackbar 
                open={openSnackbar} 
                autoHideDuration={6000} 
                onClose={() => setOpenSnackbar(false)}
                anchorOrigin={{ vertical: 'bottom', horizontal: 'left' }}
            >
                <Alert onClose={() => setOpenSnackbar(false)} severity="success" variant="filled">
                    Successfully signed in.
                </Alert>
            </Snackbar>

        </div>
    );
};

export default SignIn;