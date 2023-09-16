import React, { useState, useContext } from 'react';
// import { useNavigate, Link } from 'react-router-dom';
import './LoginPageLayout.css';
import { TextField, Button, Alert, Collapse, Snackbar} from '@mui/material';
import IconButton from '@mui/material/IconButton';
import CloseIcon from '@mui/icons-material/Close';


const SignIn = () => {
    // const navigate = useNavigate();
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [isEmailValid, setEmailValid] = useState(true);
    const [userNotFound, setUserNotFound] = useState(false);
    const [incorrectPassword, setIncorrectPassword] = useState(false);
    const [openSnackbar, setOpenSnackbar] = useState(false);
    // const { logIn } = useContext(UserContext);

    const validateEmail = (emailInput: string) => {
        const emailRegex = /^(([^<>()[\].,;:\s@"]+(\.[^<>()[\].,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        setEmailValid(emailRegex.test(emailInput));
    };

    const resetAlerts = () => {
        setUserNotFound(false);
        setIncorrectPassword(false);
    };

    const signIn = () => {
        let users // = await getUsers() - TODO: implement this function
        let user // = users.find((user) => user.email === email);
        if (!user) {
            setUserNotFound(true);
            return;
        }
        // if (user.password !== password) {
        //     setIncorrectPassword(true);
        //     return;
        // }

        console.log("Successfully signed in!");
        // logIn(email);
        resetAlerts();
        setOpenSnackbar(true);
        // setTimeout(() => {
        // navigate('/profile');
        // }, 1200);

        // localStorage.setItem('currentUserEmail', email);
        // localStorage.setItem('currentUserId', user.id);

    };


    return (
        <div className='signInContainer'>
            <h1 className='signInHeader'>Grocery Title</h1>
            <p className='blurbText'>Sign in below for access to your profile </p>

            <TextField
                label="Email"
                variant="filled"
                margin="normal"
                className="textField"
                error={!isEmailValid}
                helperText={!isEmailValid ? 'Please enter a valid email address.' : ''}
                value={email}
                onChange={(e) => {
                    setEmail(e.target.value);
                    validateEmail(e.target.value);
                }}
            />

            <TextField
                label="Password"
                type="password"
                variant="filled"
                margin="normal"
                className="textField"
                error={incorrectPassword}
                helperText={incorrectPassword ? 'Incorrect password.' : ''}
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />

            <Button 
                variant="contained" 
                className="signInButton" 
                onClick={signIn}>
                Sign In
            </Button>

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