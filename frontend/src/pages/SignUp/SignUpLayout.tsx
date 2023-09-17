import React, { useEffect } from "react";
import { useState } from "react";
import "./SignUpLayout.css";
import axios from "axios";

import { TextField, Button, Alert, Collapse } from '@mui/material';
import EmailIcon from '@mui/icons-material/Email';
import CloseIcon from '@mui/icons-material/Close';
import IconButton from '@mui/material/IconButton';

const SignUpLayout = () => {
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        email: '',
        password: '',
        passwordConfirm: ''
      });

    const [error, setError] = useState(false);
    const [isEmailValid, setIsEmailValid] = useState(false);
    const [isEmailDuplicate, setIsEmailDuplicate] = useState(false);
    const [isPasswordValid, setIsPasswordValid] = useState(false);
    const [doPasswordsMatch, setDoPasswordsMatch] = useState(false);

    const [success, setSuccess] = useState(false);
    const [fieldsFilled, setFieldsFilled] = useState(false);


    useEffect(() => {
        const filled =
          !!(formData.firstName &&
          formData.lastName &&
          formData.email &&
          formData.password &&
          formData.passwordConfirm);
        setFieldsFilled(filled);
      }, [formData]);

    const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        const { name, value } = e.target as HTMLInputElement;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleEmailChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const newEmail = e.target.value;
        setFormData({ ...formData, email: newEmail });
      
        const emailIsValid = validateEmail(newEmail);
        setIsEmailValid(emailIsValid);

    };

    const checkIfPasswordValid = (password: string) => {
        const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
        return regex.test(password);
    };

    const handlePasswordOrConfirmChange = (e: React.ChangeEvent<HTMLInputElement>) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });

        let updatedPassword = formData.password;
        let updatedPasswordConfirm = formData.passwordConfirm;
    
        if (name === "password") {
            updatedPassword = value;
        } else if (name === "passwordConfirm") {
            updatedPasswordConfirm = value;
        }

        const passwordsMatch = updatedPassword === updatedPasswordConfirm;
        const passwordIsValid = checkIfPasswordValid(updatedPassword);

        setDoPasswordsMatch(passwordsMatch);
        setIsPasswordValid(passwordIsValid);
    };

    const validateEmail = (email: string) => {
        const regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
        return regex.test(email);
      };

    const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
        console.log("Submitting form data...");
        e.preventDefault();

        try {
            const response = await axios.post('http://localhost:8080/api/v1/users/signup', formData);

                console.log("User registered successfully");
                setSuccess(true);
                setError(false);
                setIsEmailDuplicate(false);
                setFormData({
                    firstName: '',
                    lastName: '',
                    email: '',
                    password: '',
                    passwordConfirm: ''
                });
    
        } catch (error) {
            console.error("There was an error registering the user:", error);
            setError(true); 
        }
    };

    return (
        <div>
            <h1 className='signUpHeader'>Grocery Title</h1>
            <p className='blurbText'>Sign up below and become a Rewards Member</p>

            <TextField
                name="firstName"
                label="First Name"
                variant="filled"
                margin="normal"
                className="textField"
                value={formData.firstName}
                onChange={handleChange}
                required
            />
            <TextField
                name="lastName"
                label="Last Name"
                variant="filled"
                margin="normal"
                className="textField"
                value={formData.lastName}
                onChange={handleChange}
                required
            />

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
                error={formData.password ? !isPasswordValid : false}
                helperText={formData.password && !isPasswordValid ? 'Password should have at least 8 characters, including 1 uppercase, 1 lowercase, 1 number and 1 special character.' : ''}
                value={formData.password}
                onChange={handlePasswordOrConfirmChange}
                required
            />

            <TextField
                name="passwordConfirm"
                label="Confirm Password"
                type="password"
                variant="filled"
                margin="normal"
                className="textField"
                error={formData.passwordConfirm ? !doPasswordsMatch : false}
                helperText={formData.passwordConfirm && !doPasswordsMatch ? 'Passwords do not match.' : ''}
                value={formData.passwordConfirm}
                onChange={handlePasswordOrConfirmChange}
                required
            />

            <p className='privacyText'>By clicking sign up and submitting your information, you are granting us permission to email you. You may unsubscribe at any time. We will NOT share your information with any 3rd party organization.</p>
            
            <form onSubmit={handleSubmit}>
            <Button 
                type="submit"
                variant="contained" 
                className="button" 
                endIcon={<EmailIcon />} 
                disabled={!(fieldsFilled && isEmailValid && isPasswordValid &&doPasswordsMatch)}>
                Sign Up
            </Button>
            </form>

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
                        You have successfully signed up!
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
                        Sorry, your request could not be processed. This may be due to a network error, or your email may already be signed up.
                    </Alert>
                </Collapse>
            </div>
        </div>
    );
};

export default SignUpLayout;
