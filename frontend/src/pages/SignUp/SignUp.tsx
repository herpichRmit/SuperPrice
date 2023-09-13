import React from "react";
import { useState } from "react";
import "./SignUp.css";


const SignUp = () => {
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

        const user = {
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
    };

        




    return (
        <div>
        <h1>Sign Up</h1>
        </div>
    );

}

export default SignUp;