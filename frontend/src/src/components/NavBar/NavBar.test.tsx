import { describe, test, expect } from 'vitest'
import { render, screen } from '@testing-library/react'

import NavBar from './NavBar';

describe ("NavBar",  () => {
    test ('Should contain logo', () => {
        const navBar = render (<NavBar />).container;
        expect (navBar.querySelector ('.logo')).toBeTruthy ();
    });

    test ('Should contain search bar', () => {
        const navBar = render (<NavBar />).container;
        expect (navBar.querySelector ('.search-bar')).toBeTruthy ();
    });

    test ('Should not contain search bar when shouldShowSearchBar is false', () => {
        const navBar = render (<NavBar shouldShowSearchBar={false}/>).container;
        expect (navBar.querySelector ('.search-bar')).toBeFalsy ();
    });
});
