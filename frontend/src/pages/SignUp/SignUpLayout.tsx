import React from "react";
import { useState } from "react";
import "./SignUp.css";

import { TextField, Button, Alert, Collapse } from '@mui/material';
import EmailIcon from '@mui/icons-material/Email';
import CloseIcon from '@mui/icons-material/Close';
import IconButton from '@mui/material/IconButton';


const SignUpLayout = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [passwordConfirm, setPasswordConfirm] = useState("");
    const [email, setEmail] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [addressLine1, setAddressLine1] = useState("");
    const [addressLine2, setAddressLine2] = useState("");
    const [city, setCity] = useState("");
    const [state, setState] = useState("");
    const [zipCode, setZipCode] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");
    const [isEmailDuplicate, setIsEmailDuplicate] = useState(false);
    const [isEmailValid, setIsEmailValid] = useState(true);
    const [isPasswordStrong, setIsPasswordStrong] = useState(true);
    const [doPasswordsMatch, setDoPasswordsMatch] = useState(true);
    const [open, setOpen] = useState(false);
    const [success, setSuccess] = useState(false);
    const [error, setError] = useState(false);
    const [empty, setEmpty] = useState(false);

    const checkIfEmpty = () => {
        const fieldsFilled = username && password && passwordConfirm && email && firstName && lastName;
        setEmpty(!fieldsFilled);
    };

    const post = async () => {
        setError(false);
        setSuccess(false);
        setIsEmailDuplicate(false);
        setIsEmailValid(true);

        if (password === passwordConfirm) {
            setDoPasswordsMatch(true);
        } else {
            setDoPasswordsMatch(false);
        }

        const [dayOfWeek, month, day, year, time, timeZone] = new Date().toString().split(" ");
        const date = `${dayOfWeek} ${month} ${day} ${year} ${time} ${timeZone}`;
        let users // = await getUsers() - TODO: implement this function

        let user = {
            username,
            password,
            email,
            firstName,
            lastName,
            date,
            addressLine1,
            addressLine2,
            city,
            state,
            zipCode,
            phoneNumber,
        };

        // check if email exists in database - TODO: implement this function
        // const emailExists = users.some(existingUser => existingUser.email === email);

        if (!isPasswordStrong) {
            setError(true);
            return;
        }

        setUsername('');
        setFirstName('');
        setLastName('');
        setPassword('');
        setEmail('');
        setCity('');
        setState('');
        setZipCode('');
        setPhoneNumber('');
        setAddressLine1('');
        setAddressLine2('');
        setPhoneNumber('');
        setPasswordConfirm('');
        setEmpty(true);
        setOpen(false);
        setSuccess(true);
    };

    const validateEmail = (email: string) => {
        const regex = /\S+@\S+\.\S+/;
        setIsEmailValid(regex.test(email));
    };

    const validatePassword = (password: string) => {
        const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])/;
        setIsPasswordStrong(regex.test(password));
    };


    return (
        <div>
            <h1 className='signUpHeader'>Grocery Title</h1>
            <p className='blurbText'>Sign up below and become a Rewards Member</p>

            <TextField
                label="First Name"
                variant="filled"
                margin="normal"
                className="textField"
                value={firstName}
                onChange={(e) => {
                    setFirstName(e.target.value);
                    checkIfEmpty();
                }}
            />
            <TextField
                label="Last Name"
                variant="filled"
                margin="normal"
                className="textField"
                value={lastName}
                onChange={(e) => {
                    setLastName(e.target.value);
                    checkIfEmpty();
                }}
            />
            

            <TextField
                label="Email"
                variant="filled"
                margin="normal"
                error={!isEmailValid}
                className="textField"
                value={email}
                helperText={!isEmailValid ? 'Please enter a valid email address.' : ''}
                onChange={(e) => {
                    setEmail(e.target.value);
                    validateEmail(e.target.value);
                    checkIfEmpty();
                }}
            />

            <TextField
                label="Password"
                type="password"
                variant="filled"
                margin="normal"
                className="textField"
                error={!isPasswordStrong}
                helperText={!isPasswordStrong ? 'Password should have at least 8 characters, including 1 uppercase, 1 lowercase, 1 number and 1 special character.' : ''}
                value={password}
                onChange={(e) => {
                    setPassword(e.target.value);
                    validatePassword(e.target.value);
                    checkIfEmpty();
                }}
            />

            <TextField
                label="Confirm Password"
                type="password"
                variant="filled"
                margin="normal"
                className="textField"
                error={!doPasswordsMatch}
                helperText={!doPasswordsMatch ? 'Passwords do not match.' : ''}
                value={passwordConfirm}
                onChange={(e) => {
                    setPasswordConfirm(e.target.value);
                    checkIfEmpty();
                }}
            />

            <p className='privacyText'>By clicking sign up and submitting your information, you are granting us permission to email you. You may unsubscribe at any time. We will NOT share your information with any 3rd party organization.</p>
            
            <Button 
                variant="contained" 
                className="button" 
                endIcon={<EmailIcon />} 
                onClick={post} 
                disabled={!open}>
                Sign Up
            </Button>

            <div className="alertSpace">
                <Collapse in={success}>
                    <Alert
                        severity='success'
                        action={
                            <IconButton
                                aria-label="close"
                                color="inherit"
                                size="small"
                                onClick={() => setSuccess(false)}
                            >
                                <CloseIcon fontSize="inherit" />
                            </IconButton>
                        }
                        className="alert"
                    >
                        You've successfully signed up!
                    </Alert>
                </Collapse>
                <Collapse in={error}>
                    <Alert
                        severity='error'
                        action={
                            <IconButton
                                aria-label="close"
                                color="inherit"
                                size="small"
                                onClick={() => setError(false)}
                            >
                                <CloseIcon fontSize="inherit" />
                            </IconButton>
                        }
                        className="alert"
                    >
                        Sorry, your request couldn't be processed. This may be due to a network error, or your email may already be signed up.
                    </Alert>
                </Collapse>

                <Collapse in={isEmailDuplicate}>
                    <Alert
                        severity='error'
                        action={
                            <IconButton
                                aria-label="close"
                                color="inherit"
                                size="small"
                                onClick={() => setIsEmailDuplicate(false)}
                            >
                                <CloseIcon fontSize="inherit" />
                            </IconButton>
                        }
                        className="alert"
                    >
                        This email is already registered. Please choose a different one or sign in.
                    </Alert>
                </Collapse>
            </div>
        </div>
    );
};

export default SignUpLayout;